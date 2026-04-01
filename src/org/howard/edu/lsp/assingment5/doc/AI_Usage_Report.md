# Assignment 5 - AI Usage Report

## Assignment Overview
Assignment 5 involves implementing an `IntegerSet` class using Java's `ArrayList` data structure. The class provides set operations including union, intersection, difference, complement, and various utility methods for managing a collection of integers.

---

## AI Conversations and Assistance
### 1. JCF Methods Application for Set Operations
- **Query**: "Rewrite these methods from using iteration and add() to using appropriate jcf methods"
- **Assistance Provided**:
  - Use of `addAll()` for union operations
  - Use of `retainAll()` for intersection (keeping only common elements)
  - Use of `removeAll()` for difference operations (keeping non-overlapping elements)
  - Fixed syntax error in intersect() method
  - Optimized method implementations to use JCF efficiently instead of manual loops

### 2. Duplicate Handling in Set Operations
- **Query**: "How do I do it in a way that still avoids duplicates?"
- **Assistance Provided**:
  - Recommendation to use `HashSet` as an intermediate data structure
  - Strategy for union() method: create HashSet from first set, add all elements from second set (HashSet automatically deduplicates), then copy to IntegerSet
  - Clarification that retainAll() and removeAll() naturally avoid introducing duplicates
  - Added imports for `java.util.HashSet` and `java.util.Set`

### 3. Code Structure and Encapsulation
- **Query**: "If IntSet is a private variable, doesn't that mean using other.IntSet.c..." (accessing private fields)
- **Clarification Provided**: Private field access is allowed within methods of the same class, so accessing `intSetb.IntSet` within IntegerSet methods is valid Java encapsulation

---

## External Resources and References Used

### 1. Oracle Java ArrayList Documentation
- **URL**: https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
- **Purpose**: Core ArrayList API reference
- **Sections Used**:
  - Constructors: `ArrayList()`, `ArrayList(int initialCapacity)`
  - Methods: `add(E)`, `remove(int)`, `contains(Object)`, `isEmpty()`, `size()`, `clear()`
  - Bulk operations: `addAll(Collection)`, `retainAll(Collection)`, `removeAll(Collection)`

### 2. W3Schools Java Tutorial
- **URL**: https://www.w3schools.com/java/
- **Topics Used**:
  - ArrayList syntax and common operations
  - Enhanced for loops for iterating collections
  - Exception handling basics (IllegalStateException, IllegalArgumentException)