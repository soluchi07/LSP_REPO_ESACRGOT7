# Development Log – Question 2

## AI Tool Used: Claude (claude-sonnet-4-6)

I analyzed the OrderProcessor class myself and identified the design issues — poor encapsulation, too many responsibilities in one method, and misplaced logic. I also drafted the CRC card structure for the redesign on my own. I then asked Claude to write up the evaluation and CRC cards based on my notes, and edited the output for clarity and accuracy.

---

**Prompt:**
> What is the name of the design principle that says a class should only have one reason to change?

**Response:**
> That's the Single Responsibility Principle (SRP), originally articulated by Robert C. Martin. It states that a class should have one, and only one, reason to change — meaning it should encapsulate only one responsibility or concern.

---

**Prompt:**
> Write a design evaluation for this OrderProcessor class. Issues I found: public fields (no encapsulation), processOrder does too much (tax, printing, file I/O, email, discount, logging), discount is applied after receipt is already printed, magic numbers for tax rate and threshold. Reference SRP and Riel heuristics.

**Response:**
> *(Claude wrote the evaluation.md content based on the issues I identified.)*

---

**Prompt:**
> Write CRC cards for a redesigned version. I want to split it into: Order, TaxCalculator, DiscountCalculator, ReceiptPrinter, OrderRepository, EmailService, ActivityLogger, and a coordinating OrderProcessor.

**Response:**
> *(Claude wrote the CRC cards based on my decomposition.)*

---

I reviewed and edited both documents to ensure the analysis reflected my own understanding.
