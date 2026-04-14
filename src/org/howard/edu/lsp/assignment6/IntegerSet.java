package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// keep track of largest and smallest when new nums are added so its O(1) instead of O(n) for those operations

public class IntegerSet {

	private final ArrayList<Integer> IntSet;

	/**
	 * Constructs an empty integer set.
	 */
	public IntegerSet() { // done
		this.IntSet = new ArrayList<>();
	}

	/**
	 * Constructs an empty integer set with an initial capacity.
	 *
	 * @param InitialCapacity initial backing list capacity
	 */
	public IntegerSet(int InitialCapacity) { // done
		this.IntSet = new ArrayList<>(InitialCapacity);
	}

	/**
	 * Removes all elements from this set.
	 */
	public void clear() {
		this.IntSet.clear();
	}

	/**
	 * Compares this set with another set by element membership.
	 *
	 * @param b the other set to compare against
	 * @return true if both sets contain exactly the same elements
	 */
	public boolean equals(IntegerSet b) {
		return this.IntSet.containsAll(b.IntSet) && b.IntSet.containsAll(this.IntSet);
	}

	/**
	 * Checks whether this set is empty.
	 *
	 * @return true if this set has no elements
	 */
	public boolean isEmpty() {
		return this.IntSet.isEmpty();
	}

	/**
	 * Checks whether a value is present in this set.
	 *
	 * @param value value to search for
	 * @return true if the value exists in this set
	 */
	public boolean contains(int value) {
		return this.IntSet.contains(value);
	}

	/**
	 * Gets the number of elements in this set.
	 *
	 * @return current set size
	 */
	public int length() { // done
		return this.IntSet.size();
	}

	/**
	 * Returns the largest value in this set.
	 *
	 * @return largest value currently in the set
	 * @throws IllegalStateException if this set is empty
	 */
	public int largest() { // done
		if (this.IntSet.isEmpty()) {
			throw new IllegalStateException("Set is empty.");
		}
		return Collections.max(this.IntSet);
	}

	/**
	 * Returns the smallest value in this set.
	 *
	 * @return smallest value currently in the set
	 * @throws IllegalStateException if this set is empty
	 */
	public int smallest() { // done
		if (this.IntSet.isEmpty()) {
			throw new IllegalStateException("Set is empty.");
		}
		return Collections.min(this.IntSet);
	}

	/**
	 * Adds an item to this set if it is not already present.
	 *
	 * @param item value to add
	 */
	public void add(int item) { // done
		if (!this.IntSet.contains(item)) {
			this.IntSet.add(item);
		}
	}

	/**
	 * Removes an item from this set if it is present.
	 *
	 * @param item value to remove
	 */
	public void remove(int item) { // done
		this.IntSet.remove(Integer.valueOf(item));
	}

	/**
	 * Creates a new set containing all elements from this set and another set.
	 *
	 * @param intSetb set to union with this set
	 * @return a new set containing the union of both sets
	 * @throws IllegalArgumentException if intSetb is null
	 */
	public IntegerSet union(IntegerSet intSetb) { // new method
		if (intSetb == null) {
			throw new IllegalArgumentException("Input set cannot be null.");
		}

		IntegerSet temp = new IntegerSet();
		Set<Integer> combined = new HashSet<>(this.IntSet);
		combined.addAll(intSetb.IntSet);
		temp.IntSet.addAll(combined);

		return temp;
	}

	/**
	 * Creates a new set containing only elements common to this set and another
	 * set.
	 *
	 * @param intSetb set to intersect with this set
	 * @return a new set containing the intersection of both sets
	 * @throws IllegalArgumentException if intSetb is null
	 */
	public IntegerSet intersect(IntegerSet intSetb) { // new method
		if (intSetb == null) {
			throw new IllegalArgumentException("Input set cannot be null.");
		}

		IntegerSet temp = new IntegerSet(this.length());
		temp.IntSet.addAll(this.IntSet);
		temp.IntSet.retainAll(intSetb.IntSet);

		return temp;
	}

	/**
	 * Creates a new set containing elements in this set that are not in another
	 * set.
	 *
	 * @param intSetb set whose elements are removed from this set
	 * @return a new set representing this set minus intSetb
	 * @throws IllegalArgumentException if intSetb is null
	 */
	public IntegerSet diff(IntegerSet intSetb) {// new method
		if (intSetb == null) {
			throw new IllegalArgumentException("Input set cannot be null.");
		}

		IntegerSet temp = new IntegerSet(this.length());
		temp.IntSet.addAll(this.IntSet);
		temp.IntSet.removeAll(intSetb.IntSet);

		return temp;
	}

	/**
	 * Creates a new set containing elements in another set that are not in this
	 * set.
	 *
	 * @param intSetb reference set for the complement operation
	 * @return a new set representing intSetb minus this set
	 * @throws IllegalArgumentException if intSetb is null
	 */
	public IntegerSet complement(IntegerSet intSetb) {// new method
		if (intSetb == null) {
			throw new IllegalArgumentException("Input set cannot be null.");
		}

		IntegerSet temp = new IntegerSet(intSetb.length());
		temp.IntSet.addAll(intSetb.IntSet);
		temp.IntSet.removeAll(this.IntSet);

		return temp;
	}

	/**
	 * Returns a sorted string representation of this set.
	 *
	 * @return sorted string form of this set
	 */
	@Override
	public String toString() {
		ArrayList<Integer> sortedList = new ArrayList<>(this.IntSet);

		Collections.sort(sortedList);

		return sortedList.toString();
	}

}