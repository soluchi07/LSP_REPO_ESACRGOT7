package org.howard.edu.lsp.assingment5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set; 


// keep track of largest and smallest when new nums are added so its O(1) instead of O(n) for those operations

public class IntegerSet{

    private final ArrayList<Integer> IntSet;
    
	/** Constructs an empty IntegerSet. */
    public IntegerSet(){ //done
        this.IntSet = new ArrayList<>();
    }

	/** Constructs an empty IntegerSet with initial capacity. */
	public IntegerSet(int InitialCapacity){ //done
		this.IntSet = new ArrayList<>(InitialCapacity);
	}

	/** Removes all elements from this set. */
	public void clear(){
		this.IntSet.clear();
	}

	/**Returns true if both sets contain exactly the same elements. */
	public boolean equals(IntegerSet b){
		return this.IntSet.containsAll(b.IntSet) && b.IntSet.containsAll(this.IntSet);
	}


	/** Returns true if this set has no elements. */
	public boolean isEmpty(){
		return this.IntSet.isEmpty();
	}

	/** Returns true if value exists in this set. */
	public boolean contains(int value){
		return this.IntSet.contains(value);
	}
	
	/** Returns number of elements in this set. */
	public int length(){ // done
		return this.IntSet.size();
    }
	
	/**
     * Returns largest value in the set.
     * @throws IllegalStateException if set is empty
     */
	public int largest(){ // done
		if (this.IntSet.isEmpty()) {
			throw new IllegalStateException("Set is empty.");
		}
		return Collections.max(this.IntSet);
	}

	/**
     * Returns smallest value in the set.
     * @throws IllegalStateException if set is empty
     */
	public int smallest(){ // done
		if (this.IntSet.isEmpty()) {
			throw new IllegalStateException("Set is empty.");
		}
		return Collections.min(this.IntSet);
	}

	/** Adds item if it does not already exist. */
	public void add(int item){ // done
		if (!this.IntSet.contains(item)){
			this.IntSet.add(item);
		}
	}

	/** Removes item if present. */
	public void remove(int item){ // done
		this.IntSet.remove(Integer.valueOf(item));
	}


	public IntegerSet union(IntegerSet intSetb){ // new method
		if (intSetb == null) {
			throw new IllegalArgumentException("Input set cannot be null.");
		}

		IntegerSet temp = new IntegerSet();
		Set<Integer> combined = new HashSet<>(this.IntSet);
		combined.addAll(intSetb.IntSet);
		temp.IntSet.addAll(combined);

		return temp;
	}
	
	public IntegerSet intersect(IntegerSet intSetb){ // new method
		if (intSetb == null) {
			throw new IllegalArgumentException("Input set cannot be null.");
		}
		
		IntegerSet temp = new IntegerSet(this.length());
		temp.IntSet.addAll(this.IntSet);
		temp.IntSet.retainAll(intSetb.IntSet);

		return temp;
	}
	
	public IntegerSet diff(IntegerSet intSetb){// new method
		if (intSetb == null) {
			throw new IllegalArgumentException("Input set cannot be null.");
		}
		
		IntegerSet temp = new IntegerSet(this.length());
		temp.IntSet.addAll(this.IntSet);
		temp.IntSet.removeAll(intSetb.IntSet);

		return temp;
	}
	
	public IntegerSet complement(IntegerSet intSetb){// new method
		if (intSetb == null) {
			throw new IllegalArgumentException("Input set cannot be null.");
		}
		
		IntegerSet temp = new IntegerSet(intSetb.length());
		temp.IntSet.addAll(intSetb.IntSet);
		temp.IntSet.removeAll(this.IntSet);

		return temp;
	}
	
	@Override
	public String toString() {
		ArrayList<Integer> sortedList = new ArrayList<>(this.IntSet);
		
		Collections.sort(sortedList);

		return sortedList.toString();
	}

}