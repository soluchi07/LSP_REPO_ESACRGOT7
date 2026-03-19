# Development Log – Question 1

## AI Tool Used: Claude (claude-sonnet-4-6)

I designed the class structure myself from the CRC cards — identifying the fields, method signatures, and the appropriate data structure for TaskManager. I then asked Claude to write the code based on my design, and edited the output to match my intended behavior and style.

---

**Prompt:**
> Which Java collection prevents duplicate keys and preserves insertion order? I'm building a task manager that needs to look up tasks by ID.

**Response:**
> `LinkedHashMap` is a good fit. It extends `HashMap` so keys are unique (duplicate puts overwrite), and it maintains insertion order. If you want to throw an exception on duplicates rather than silently overwrite, check `containsKey()` before calling `put()`.

---

**Prompt:**
> Write a Task class with fields taskId, description, and status. Default status is OPEN. setStatus should only accept OPEN, IN_PROGRESS, or COMPLETE — anything else sets it to UNKNOWN. Include a toString in the format: taskId description [status].

**Response:**
> *(Claude generated the Task class with the constructor, getters, setStatus validation, and toString.)*

---

**Prompt:**
> Now write TaskManager using LinkedHashMap. addTask should throw IllegalArgumentException on duplicate IDs. findTask returns null if not found. getTasksByStatus returns a List of matching tasks.

**Response:**
> *(Claude generated the TaskManager class with addTask, findTask, and getTasksByStatus.)*

---

I reviewed both classes, verified they matched my design, and made edits to the Javadoc and formatting before finalizing.
