# Reflection: Assignment 2 vs. Assignment 3

## Overview

Both assignments implement the same ETL (Extract-Transform-Load) pipeline: read
`data/products.csv`, apply a set of business rule transformations, and write the
result to `data/transformed_products.csv`. The requirements, inputs, outputs, and
error handling are identical. What changed entirely is the *design* of the solution.

---

## What Is Different About the Design?

Assignment 2 (`org.howard.edu.lsp.assignment2.ETLPipeline`) is a single 141-line
class. All logic lives in one file: file reading, row validation, name
normalization, discount calculation, price rounding, category upgrading, price
range labeling, and file writing are processed together inside one `main()` loop,
supported by a set of private static helper methods (`splitByLines`, `getFields`,
`isNumeric`, `isInt`, `roundToTwo`, `getPriceRange`, `writeOutput`). Data is
represented throughout as raw `List<String>` fields indexed by position — for
example, `fields.get(2)` means "the price column." There are no named types for
product data.

Assignment 3 distributes the same work across five classes, each in its own file:

| Class | Responsibility |
|---|---|
| `Product` | Holds the data for one product row with typed, named fields |
| `CSVRead` | Extract phase — reads the file, validates rows, returns `List<Product>` |
| `ProductTransform` | Transform phase — applies all business rules |
| `CSVWrite` | Load phase — formats and writes the output CSV |
| `ETLPipeline` | Orchestrator — wires the three phases together in `main()` |

Data is no longer a raw list of strings. A `Product` object has fields `productId`,
`name`, `price`, and `category`, each with an explicit type (`int`, `String`,
`double`). Accessing the price is `p.getPrice()`, not `fields.get(2)`.

---

## How Is Assignment 3 More Object-Oriented?

Assignment 2 uses a class as a container for static utility functions. There are no
instances — every method is `static` and every data structure is a local variable.
This is procedural programming organized inside a class wrapper, not true OO design.

Assignment 3 creates actual *objects*. `CSVRead`, `ProductTransform`, `CSVWrite`,
and `ETLPipeline` are instantiated with `new` before use. Each object owns its
behavior and state. No method in Assignment 3 is `static` except `main()`, which is
required by Java. The three pipeline stages communicate through a shared `Product`
type, not through raw string lists.

The `main()` method in Assignment 3 is five meaningful lines:

```java
CSVRead reader         = new CSVRead();
ProductTransform transformer = new ProductTransform();
CSVWrite writer        = new CSVWrite();
List<Product> products = reader.read("data/products.csv");
transformer.transform(products);
writer.write(products, "data/transformed_products.csv");
```

In Assignment 2, `main()` is 60 lines of mixed concerns. The improvement is not
cosmetic — the phases are now independently testable, understandable, and modifiable
without touching unrelated code.

---

## Which OO Ideas Were Used?

**Object and Class** — The `Product` class models a real-world entity (a product
record) as a first-class citizen of the program. `CSVRead`, `ProductTransform`, and
`CSVWrite` each model a coherent concept (a data source, a rule set, a data sink).

**Encapsulation** — All five fields in `Product` (`productId`, `name`, `price`,
`category`, `priceRange`) are declared `private` and accessed only through public
getters and setters. Implementation details are hidden inside each class: the
validation helpers `isInt` and `isNumeric` in `CSVRead` are private; `roundToTwo`
and `getPriceRange` in `ProductTransform` are private; `formatPrice` in `CSVWrite`
is private. None of these are visible to callers.

**Inheritance** — Inheritance was not applied in this design. The five classes do not
form a specialization hierarchy because none of them is a subtype of another. Using
inheritance where it is not warranted would violate the "is-a rule" from the coding
standards; composition and delegation are used instead.

**Polymorphism** — Polymorphism was not applied in this design for similar reasons:
there is only one reader, one transformer, and one writer. If future requirements
introduced multiple input formats (JSON, XML) or multiple transformation strategies,
a `DataSource` interface with multiple implementations would be the natural
extension point.

---

## Testing: Confirming Assignment 3 Matches Assignment 2

Both implementations were run against the same `data/products.csv` input file and
produced byte-for-byte identical output in `data/transformed_products.csv`:

```
ProductID,Name,Price,Category,PriceRange
7,USB CABLE,8.99,Electronics,Low
8,OFFICE CHAIR,150.00,Furniture,High
9,4K TV,1080.00,Premium Electronics,Premium
10,GIFT CARD,10.00,Other,Low
11,MOUSE,23.00,Electronics,Medium
12,TABLE,500.00,Furniture,High
13,CAMERA,500.40,Premium Electronics,Premium
```

Three additional cases were verified:

1. **Missing input file** — deleting `data/products.csv` and running `ETLPipeline`
   prints `An error occurred. File not found` and exits, matching Assignment 2.

2. **Empty input file** — replacing `data/products.csv` with an empty file prints
   `File is empty. Incorrect input` and exits, matching Assignment 2.

3. **Malformed rows** — rows with a non-integer ProductID (`badid`), a non-numeric
   Price (`abc`), the wrong number of fields (3 or 5), or a blank line are all
   silently skipped, and only valid rows appear in the output, matching Assignment 2.
