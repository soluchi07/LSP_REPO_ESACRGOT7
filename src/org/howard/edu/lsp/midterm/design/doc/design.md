# Proposed Redesign – CRC Cards

---

**Class:** Order

**Responsibilities:**
- Store customer name, email, item, and price
- Provide read access to order data
- Apply a discount and return the discounted price

**Collaborators:**
- DiscountCalculator

---

**Class:** DiscountCalculator

**Responsibilities:**
- Determine whether a discount applies based on price
- Calculate and return the discounted total

**Collaborators:**
- Order

---

**Class:** TaxCalculator

**Responsibilities:**
- Calculate tax for a given price
- Return the total price including tax

**Collaborators:**
- none

---

**Class:** ReceiptPrinter

**Responsibilities:**
- Format and print an order receipt to standard output

**Collaborators:**
- Order

---

**Class:** OrderRepository

**Responsibilities:**
- Persist order records to a file or other storage
- Handle I/O exceptions

**Collaborators:**
- Order

---

**Class:** EmailService

**Responsibilities:**
- Send a confirmation email to the customer

**Collaborators:**
- Order

---

**Class:** ActivityLogger

**Responsibilities:**
- Log the timestamp and result of order processing

**Collaborators:**
- none

---

**Class:** OrderProcessor

**Responsibilities:**
- Coordinate the order-processing workflow by delegating to collaborators

**Collaborators:**
- Order, TaxCalculator, DiscountCalculator, ReceiptPrinter, OrderRepository, EmailService, ActivityLogger
