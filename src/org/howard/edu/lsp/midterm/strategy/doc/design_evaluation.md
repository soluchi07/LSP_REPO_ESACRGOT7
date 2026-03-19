# Design Evaluation – PriceCalculator

## Problem with the Original Design

The original `PriceCalculator.calculatePrice()` method uses a chain of `if` statements to select pricing logic based on a `String` customer type. This design violates the **Open/Closed Principle**: every time a new customer type is introduced (e.g., `"STUDENT"`, `"SENIOR"`), the method must be modified rather than extended.

Additional issues:
- All discount logic lives in one place, making it harder to read, test, and maintain as the number of types grows.
- The method has no way to validate unknown customer types; unrecognized strings silently fall through, returning the original price.
- Behavior cannot be swapped at runtime without changing the method signature or adding more conditions.

## How the Strategy Pattern Solves This

By extracting each discount calculation into its own class implementing a `DiscountStrategy` interface, each behavior becomes an independent unit. `PriceCalculator` depends on the abstraction, not on concrete types. Adding a new discount type means adding a new class — no existing code is modified.
