# Design Evaluation – OrderProcessor

## Issues Observed

**1. Single class with too many responsibilities (violation of Single Responsibility Principle)**
`OrderProcessor.processOrder()` handles tax calculation, receipt printing, file I/O, email notification, discount application, and activity logging all in one method. This is the most fundamental problem: a class should have one reason to change. Here, any change to tax logic, file format, email behavior, or logging requires modifying the same class.

**2. Poor encapsulation (public fields)**
`customerName`, `email`, `item`, and `price` are all `public`. This exposes internal state directly, allowing any external code to modify fields without validation and breaking the principle that an object should control access to its own data (Riel Heuristic: a class should not expose its internal implementation).

**3. God Method anti-pattern**
`processOrder()` is a monolithic method that knows too much and does too much. According to Riel's heuristics, methods should represent a single, well-defined behavior. A method that touches tax, persistence, messaging, discounts, and logging is brittle and untestable.

**4. Misplaced discount logic**
The discount is applied *after* the receipt has already been printed and saved to the file, meaning the saved and displayed totals do not reflect the discounted price. This is a logic error that results from cramming unrelated concerns into one method.

**5. Hard-coded tax rate and magic numbers**
The tax rate `0.07` and the discount threshold `500` / multiplier `0.9` are literals embedded in the method. Any change to business rules requires editing the source code rather than configuration.

**6. No abstraction over external systems**
The class directly creates a `FileWriter`, making it impossible to test without writing to disk and impossible to swap storage implementations without modifying the class (violates the Open/Closed Principle).

## Summary
The class fails to distribute responsibilities across collaborating objects and exposes its state publicly. As the system grows, every new requirement (new discount tier, different output format, database persistence) forces changes to this single class, increasing the risk of regression bugs and making unit testing impractical.
