# Development Log – Question 3

## AI Tool Used: Claude (claude-sonnet-4-6)

I planned the refactoring myself — identifying that the if-chain violated OCP and that the Strategy Pattern was the right fix. I mapped out the interface, the four concrete strategy classes, and the updated PriceCalculator before writing any code. I then asked Claude to write the code based on my design and edited the output before finalizing.

---

**Prompt:**
> In the Strategy Pattern, should the context class (PriceCalculator) hold a reference to the interface or to the concrete strategy classes?

**Response:**
> It should hold a reference to the interface. That's the key to the pattern — the context depends on the abstraction (`DiscountStrategy`), not on any concrete implementation. The concrete strategy is injected at runtime (via constructor or setter), so the context never needs to know which specific strategy it's using.

---

**Prompt:**
> Write a DiscountStrategy interface with one method: applyDiscount(double price) returning double. Then write four implementations: RegularDiscountStrategy (no discount), MemberDiscountStrategy (10% off), VIPDiscountStrategy (20% off), HolidayDiscountStrategy (15% off).

**Response:**
> *(Claude generated the interface and four strategy classes.)*

---

**Prompt:**
> Now write a PriceCalculator class that takes a DiscountStrategy in its constructor, has a setStrategy method, and a calculatePrice method that delegates to the strategy.

**Response:**
> *(Claude generated the refactored PriceCalculator.)*

---

**Prompt:**
> Write a Driver that runs all four strategies on a base price of 100.0 and prints: REGULAR: 100.0, MEMBER: 90.0, VIP: 80.0, HOLIDAY: 85.0.

**Response:**
> *(Claude generated the Driver.)*

---

I reviewed all generated code, verified correctness against the expected output, and edited Javadoc and formatting throughout.
