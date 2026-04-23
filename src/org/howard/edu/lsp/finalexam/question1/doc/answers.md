Part 1:
Shared Resource #1: `nextId` (int field) — read and incremented by `getNextId()`, which can be called by multiple threads simultaneously, making the read-modify-write non-atomic.

Shared Resource #2: `requests` (ArrayList<String>) — a non-thread-safe list that multiple threads can call `add()` on concurrently, risking internal corruption.

Concurrency Problem: Race condition — two threads calling `addRequest()` at the same time may interleave their operations on `nextId` (producing duplicate IDs) and on `requests` (corrupting the ArrayList's internal state).

Why addRequest() is unsafe: `addRequest()` is a compound operation: it first calls `getNextId()`, which is a non-atomic read-modify-write operation on `nextId`, and then calls `requests.add()` on a non-thread-safe ArrayList. Neither step is protected. Two threads can both read the same value of `nextId` before either increments it, assigning the same ID to two different requests. Additionally, concurrent calls to `ArrayList.add()` can corrupt the list's internal array, causing lost entries or exceptions.

Part 2:
Fix A: NOT correct. Synchronizing only `getNextId()` makes the ID counter atomic, but `addRequest()` remains unsynchronized. Two threads can each finish `getNextId()` with unique IDs and then both call `requests.add()` at the same time on the non-thread-safe ArrayList. The shared list is still unprotected, so data corruption of `requests` can still occur.

Fix B: CORRECT. Synchronizing `addRequest()` places the entire compound operation inside a single critical section. Because only one thread at a time can hold the lock and execute `addRequest()`, both shared resources (`nextId` and `requests`) are fully protected. No two threads can interleave their reads and writes, eliminating the race condition.

Fix C: NOT correct. Synchronizing `getRequests()` only protects the act of returning the list reference to a caller. It does nothing to prevent multiple threads from simultaneously executing `addRequest()`. The race condition on `nextId` and the unsynchronized writes to `requests` inside `addRequest()` remain completely unaddressed.

Part 3:
Answer: No, `getNextId()` should NOT be public.

Explanation: According to Riel's heuristic H2.1 — "All data should be hidden within its class" — a class should expose only the interface that external callers genuinely need. `getNextId()` is an internal implementation detail of how `RequestManager` assigns IDs before adding a request. External callers only need `addRequest()`; they have no legitimate reason to call `getNextId()` directly. Making it public violates information hiding, leaks the ID counter as part of the public interface, and allows callers to invoke it without any synchronization, undermining any concurrency fix applied to `addRequest()`.

Part 4:
Description:
The alternative approach discussed in lecture is using classes from the `java.util.concurrent` package instead of the `synchronized` keyword. Specifically, `AtomicInteger` can replace the plain `int nextId` field because it provides atomic operations like `getAndIncrement()` that read, increment, and return the old value in a single uninterruptible step — no lock needed. `CopyOnWriteArrayList` can replace the plain `ArrayList` because it is a thread-safe list implementation that handles concurrent writes internally. Together, these two classes make `addRequest()` thread-safe without any explicit `synchronized` block or method.

Code Snippet:
```java
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestManager {
    private AtomicInteger nextId = new AtomicInteger(1);
    private List<String> requests = new CopyOnWriteArrayList<>();

    public void addRequest(String studentName) {
        int id = nextId.getAndIncrement();
        requests.add("Request-" + id + " from " + studentName);
    }

    public List<String> getRequests() {
        return requests;
    }
}
```
