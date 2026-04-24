Heuristic 1:
Name:
"All data should be hidden within its class"

Explanation:
This heuristic improves maintainability by ensuring that users of a class are dependent only on its public interface and not its internal implementation or data representation. It is the fundamental basis for coding standards that require making all data attributes **"private."** It allows programmers to interact with a class without needing to understand its complex internal details and ensures users can only access the data they absolutely need to.

Heuristic 2:
Name:
"Do not create god classes/objects in your system"

Explanation:
Avoiding "god classes" improves maintainability by preventing a single class from becoming an **"omnipotent controller"** that handles too much of the system's logic or data. In lecture, this was illustrated with a **home heating system** where an initial design used a `HeatFlowRegulator` to pull in all information from `Room` and `Furnace` classes to make decisions. We noted a practical way to identify this problem: if every developer in a group is asked which class they would avoid writing and they all point to the same one, that class is likely a god class.

Heuristic 3:
Name:
"Distribute system intelligence horizontally as uniformly as possible"

Explanation:
This heuristic improves maintainability and flexibility by ensuring that top-level classes share work uniformly rather than relying on a centralized control flow. In lecture, this was illustrated by revising the home heating system example: instead of a central regulator performing all calculations, the **`Room` class was given intelligence** to determine if it needed heat through a `do_I_need_heat()` method. This change made the system more decentralized, simpler, and less dependent on the specific internal structures of the room's data.