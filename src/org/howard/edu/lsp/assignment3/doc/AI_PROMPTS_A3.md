# AI Prompt Transcript
## Prompt #1
ignore the comments on the file.

The purpose of this program is to implement a simple Extract-Transform-Load (ETL) pipeline in Java. You will read a CSV file, apply a defined set of transformations, and write the transformed data to a new CSV file.

Let's brainstorm ways to make it more object-oriented.

## Prompt #2

I've implemented these classes using the generally the same logic and noting that when using printf with BigDecimal, consider using toPlainString(). Confirm that the current object oriented structure meets the following coding requirements:

Naming Conventions
- Class Names: Use singular nouns and begin each word with a capital letter (e.g., BankAccount rather than bankAccount).
- Descriptive Naming: Choose highly descriptive and meaningful names, even if they are long.
- Verb Suspicion: Be cautious of class names that are verbs or contain suffixes like "-er" or "-or" (e.g., DataLoader), as these often indicate "Controller" classes that separate data from behavior.
- God Class Warning: Avoid class names containing terms like "Driver", "Manager", "System", or "Subsystem", which often signal a "God class" that controls too much of the system.

Class Organization and Design
- Consistent Layout: Maintain a consistent physical layout of code and organize class elements in a specific order: variables first, followed by constructors, then public methods, and finally private methods.
- Single Abstraction: A class should capture one and only one key abstraction and avoid mixing unrelated functionalities.
- Uniform Intelligence: Distribute system logic as uniformly as possible across classes rather than centralizing control in one place.
- Avoid Duplication: Do not "clone" code; instead, create a new method to house shared logic to ensure bugs are fixed in a single location.
- Separation of Concerns: Do not mix User Interface (UI) code with non-UI code; interacting with users should happen in separate classes to make logic more reusable.

Access Control and Encapsulation
- Private Data: All data attributes should be hidden within the class by making them private.
- Minimal Interfaces: Minimize the number of operations in a class's public interface and do not clutter it with items users cannot or should not use.
- Accessor Caution: Beware of classes with too many get and set operations, which can be a symptom of poor responsibility distribution.

Inheritance and Relationships
- The "Isa Rule": Only use inheritance to model specialization hierarchies where a subclass truly "is a" kind of its superclass (e.g., "A Checking Account is an Account").
- Liskov Substitution: Ensure that a subclass can safely substitute for its superclass and implements the full set of base class behaviors.
- Specialization vs. Role: Ensure abstractions modeled as classes are actual entities and not just roles that objects play.
- Limit Dependencies: Derived classes must know about their base classes, but base classes should not know anything about their derived classes.
- Prefer Composition: Favor association or composition over inheritance for "has-a" relationships.

Readability and Documentation
- Human-Centric Coding: Write programs for people to read; always choose the simpler alternative and reject "clever" code that is difficult to understand.
- Strategic Commenting: Comments should make up 25-50% of the code.
- Comment the Non-Obvious: Extensively comment logic that is not obvious, but avoid commenting code that is.
- Standard Documentation: Use Javadoc formatting for comments so documentation can be automatically generated from the source code.

Error Handling and Efficiency
- Exceptions: Use try-catch blocks to trap and handle anything that can go wrong through the raising of an Exception.
- Avoid Cleverness: Shorter code is not necessarily better if it sacrifices clarity for perceived efficiency.