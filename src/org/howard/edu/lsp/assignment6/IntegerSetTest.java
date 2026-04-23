package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.howard.edu.lsp.assignment6.IntegerSet;
import org.junit.jupiter.api.Test;

public class IntegerSetTest {

	/**
	 * Verifies the default constructor creates empty, independent sets.
	 */
	@Test
	void defaultConstructor_normalAndEdge_createsEmptyIndependentSets() {
		IntegerSet setA = new IntegerSet();
		IntegerSet setB = new IntegerSet();

		assertEquals(0, setA.length());
		assertTrue(setA.isEmpty());

		setA.add(10);
		assertFalse(setB.contains(10));
	}

	/**
	 * Verifies the capacity constructor accepts valid sizes and rejects negatives.
	 */
	@Test
	void capacityConstructor_normalAndEdge_handlesValidAndInvalidCapacity() {
		IntegerSet set = new IntegerSet(5);

		assertTrue(set.isEmpty());
		assertEquals(0, set.length());

		assertThrows(IllegalArgumentException.class, () -> new IntegerSet(-1));
	}

	/**
	 * Verifies clear removes all values and remains safe on an already empty set.
	 */
	@Test
	void clear_normalAndEdge_clearsPopulatedAndEmptySet() {
		IntegerSet set = new IntegerSet();
		set.add(1);
		set.add(2);

		set.clear();
		assertTrue(set.isEmpty());

		set.clear();
		assertEquals(0, set.length());
	}

	/**
	 * Verifies equals compares membership, not insertion order, and detects differences.
	 */
	@Test
	void equals_normalAndEdge_matchesSameMembershipDifferentOrderAndDetectsDifference() {
		IntegerSet setA = new IntegerSet();
		setA.add(1);
		setA.add(2);
		setA.add(3);

		IntegerSet setB = new IntegerSet();
		setB.add(3);
		setB.add(2);
		setB.add(1);

		assertTrue(setA.equals(setB));

		setB.add(4);
		assertFalse(setA.equals(setB));
	}

	/**
	 * Verifies isEmpty reflects whether the set contains any elements.
	 */
	@Test
	void isEmpty_normalAndEdge_emptyVsNonEmpty() {
		IntegerSet set = new IntegerSet();

		assertTrue(set.isEmpty());

		set.add(42);
		assertFalse(set.isEmpty());
	}

	/**
	 * Verifies contains reports both present and absent values correctly.
	 */
	@Test
	void contains_normalAndEdge_reportsPresentAndNotPresentValues() {
		IntegerSet set = new IntegerSet();
		set.add(7);

		assertTrue(set.contains(7));
		assertFalse(set.contains(99));
	}

	/**
	 * Verifies length counts unique elements and ignores duplicate adds.
	 */
	@Test
	void length_normalAndEdge_tracksSizeWithUniqueAndDuplicateAdds() {
		IntegerSet set = new IntegerSet();
		set.add(1);
		set.add(2);

		assertEquals(2, set.length());

		set.add(2);
		assertEquals(2, set.length());
	}

	/**
	 * Verifies largest returns the maximum value and fails on an empty set.
	 */
	@Test
	void largest_normalAndEdge_singleElementAndEmptyException() {
		IntegerSet set = new IntegerSet();
		set.add(8);

		assertEquals(8, set.largest());

		IntegerSet empty = new IntegerSet();
		assertThrows(IllegalStateException.class, empty::largest);
	}

	/**
	 * Verifies smallest returns the minimum value and fails on an empty set.
	 */
	@Test
	void smallest_normalAndEdge_singleElementAndEmptyException() {
		IntegerSet set = new IntegerSet();
		set.add(8);

		assertEquals(8, set.smallest());

		IntegerSet empty = new IntegerSet();
		assertThrows(IllegalStateException.class, empty::smallest);
	}

	/**
	 * Verifies add inserts new values and ignores duplicates.
	 */
	@Test
	void add_normalAndEdge_addsUniqueValueAndIgnoresDuplicate() {
		IntegerSet set = new IntegerSet();
		set.add(5);

		assertTrue(set.contains(5));
		assertEquals(1, set.length());

		set.add(5);
		assertEquals(1, set.length());
	}

	/**
	 * Verifies remove deletes existing values and leaves missing values unchanged.
	 */
	@Test
	void remove_normalAndEdge_removesPresentValueAndIgnoresMissingValue() {
		IntegerSet set = new IntegerSet();
		set.add(1);
		set.add(2);

		set.remove(1);
		assertFalse(set.contains(1));

		int before = set.length();
		set.remove(999);
		assertEquals(before, set.length());
	}

	/**
	 * Verifies union combines all unique values and handles empty operands.
	 */
	@Test
	void union_normalAndEdge_unitesOverlappingSetsAndHandlesEmptySet() {
		IntegerSet setA = new IntegerSet();
		setA.add(1);
		setA.add(2);

		IntegerSet setB = new IntegerSet();
		setB.add(2);
		setB.add(3);

		IntegerSet union = setA.union(setB);
		assertEquals("[1, 2, 3]", union.toString());

		IntegerSet empty = new IntegerSet();
		IntegerSet unionWithEmpty = setA.union(empty);
		assertEquals("[1, 2]", unionWithEmpty.toString());
	}

	/**
	 * Verifies intersect keeps only shared values and returns empty for disjoint sets.
	 */
	@Test
	void intersect_normalAndEdge_getsCommonElementsAndNoCommonElements() {
		IntegerSet setA = new IntegerSet();
		setA.add(1);
		setA.add(2);
		setA.add(3);

		IntegerSet setB = new IntegerSet();
		setB.add(2);
		setB.add(4);

		IntegerSet intersect = setA.intersect(setB);
		assertEquals("[2]", intersect.toString());

		IntegerSet setC = new IntegerSet();
		setC.add(8);
		setC.add(9);
		assertEquals("[]", setA.intersect(setC).toString());
	}

	/**
	 * Verifies diff removes values found in the other set and handles identical sets.
	 */
	@Test
	void diff_normalAndEdge_subtractsSubsetAndIdenticalSetsBecomeEmpty() {
		IntegerSet setA = new IntegerSet();
		setA.add(1);
		setA.add(2);
		setA.add(3);

		IntegerSet setB = new IntegerSet();
		setB.add(2);

		IntegerSet diff = setA.diff(setB);
		assertEquals("[1, 3]", diff.toString());

		IntegerSet identicalA = new IntegerSet();
		identicalA.add(4);
		identicalA.add(5);
		IntegerSet identicalB = new IntegerSet();
		identicalB.add(4);
		identicalB.add(5);
		assertEquals("[]", identicalA.diff(identicalB).toString());
	}

	/**
	 * Verifies complement returns values present in the reference set but not the base set.
	 */
	@Test
	void complement_normalAndEdge_computesRelativeComplementAndDisjointSets() {
		IntegerSet base = new IntegerSet();
		base.add(1);
		base.add(2);

		IntegerSet reference = new IntegerSet();
		reference.add(2);
		reference.add(3);
		reference.add(4);

		IntegerSet complement = base.complement(reference);
		assertEquals("[3, 4]", complement.toString());

		IntegerSet disjointA = new IntegerSet();
		disjointA.add(10);
		IntegerSet disjointB = new IntegerSet();
		disjointB.add(20);
		disjointB.add(30);
		assertEquals("[20, 30]", disjointA.complement(disjointB).toString());
	}

	/**
	 * Verifies toString returns sorted bracketed output and formats empty sets correctly.
	 */
	@Test
	void toString_normalAndEdge_returnsSortedFormatAndEmptyBrackets() {
		IntegerSet set = new IntegerSet();
		set.add(3);
		set.add(1);
		set.add(2);

		assertEquals("[1, 2, 3]", set.toString());

		IntegerSet empty = new IntegerSet();
		assertEquals("[]", empty.toString());
	}
}
