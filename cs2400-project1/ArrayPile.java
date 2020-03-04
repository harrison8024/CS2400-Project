import java.util.Arrays;

/**
	A class that implements a Pile of books by using an array.
	The Pile has no maximum and can only add and remove from the top.
	@author Harrison B. Chen
	@version 1.0
*/
public final class ArrayPile<T> implements PileInterface<T> {
	
	private T[] pile; // Cannot be final due to doubling
	private int topIndex;
	private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 50; // Initial capacity of pile
	private static final int MAX_CAPACITY = 10000;
	
	/** Creates an empty pile whose initial capacity is 50. */
	public ArrayPile() throws IllegalCapacityException {
		this(DEFAULT_CAPACITY);
	} // end default constructor
	
	/** Creates an empty pile having a given initial capacity.
	 	@param initialCapacity
	 	@throws IllegalCapacityException if initialCapacity is larger than MAX_CAPACITY  */
	public ArrayPile(int initialCapacity) throws IllegalCapacityException {
		integrityOK = false;
		checkCapacity(initialCapacity);
		
		@SuppressWarnings("unchecked")
		T[] tempPile = (T[]) new Object[initialCapacity]; // Unchecked cast
		pile = tempPile;
		topIndex = -1;
		integrityOK = true;
		
	} // end constructor
	
	/** Adds a new entry to this pile.
    @param newEntry  The object to be added as a new entry.
    @throws IntegrityException if receiving object is not initialized */
	public void add(T newEntry) throws IntegrityException {
		checkIntegrity();
		ensureCapacity();
		
		pile[topIndex + 1] = newEntry;
		topIndex++;
	} // end add
	
	/** Removes the top entry from this pile.
    @return  the entry that is being removed */
	public T remove() throws IntegrityException, EmptyPileException {
		checkIntegrity();
		
		if(!isEmpty()) {
			T result = pile[topIndex];
			pile[topIndex] = null;
			topIndex--;
			return result;
		}
		else {
			throw new EmptyPileException("Pile is Empty, can not perform remove.");
		}
	} // end remove
	
	/** Return this pile's top entry.
	@return The object at the top of the pile.
	@throws EmptyStackException if the pile is empty. */
	public T look() throws EmptyPileException{
		if(!isEmpty()) {
			return pile[topIndex];
		}
		else {
			throw new EmptyPileException("Pile is Empty, can not perform look.");
		}
	} // end look
	
	/** Gets the current number of entries in this pile.
    @return  The integer number of entries currently in this pile. */
	public int getCurrentSize() {
		return topIndex + 1;
	} // end getCurrentSize
	
	/** Sees whether this pile is empty.
    @return  True if this pile is empty, or false if not. */
	public boolean isEmpty() {
		return topIndex == -1;
	} // end isEmpty
	
	/** Clear all entries in the pile. */
	public void clear() {
		integrityOK = false;
		@SuppressWarnings("unchecked")
		T[] tempPile = (T[]) new Object[DEFAULT_CAPACITY];
		pile = tempPile;
		topIndex = -1;
		integrityOK = true;
	} // end clear
	
	/** Returns this pile in an array form.
	@return The array of the objects in the pile. 
	@throws IntegrityException if receiving object is not initialized。 */
	public T[] toArray() throws IntegrityException {
		checkIntegrity();
		
		// The cast is safe because the new array contains null entries.
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[topIndex + 1]; // Unchecked cast
		if(!isEmpty()) {
			for (int i = 0; i <= topIndex; i++) {
				result[i] = pile[i];
			} // end for
		} // end if
      return result;
	} // end toArray
	
	// Throws an exception if the client requests a capacity that is too large.
	private void checkCapacity(int capacity) throws IllegalCapacityException {
		if(capacity < 0 || capacity > MAX_CAPACITY) {
			throw new IllegalCapacityException("capacity exceed Max Capacity");
		}
	} // end checkCapacity
	
	// Throws an exception if receiving object is not initialized.
	private void checkIntegrity() throws IntegrityException {
		if(!integrityOK) {
			throw new IntegrityException("Integrity not OK");
		}
	} // end checkIntegrity
	
	// Double the array when the pile reach the capacity limit.
	private void ensureCapacity() {
		if(topIndex == pile.length - 1) {
			pile = Arrays.copyOf(pile, 2 * pile.length);
		}
	} // end ensureCapacity
} // end ArrayPile

// A class for IllegalCapacityException
@SuppressWarnings("serial")
class IllegalCapacityException extends Exception {

	public IllegalCapacityException(String message) {
		super(message);
	}
}

// A class for IntegrityException
@SuppressWarnings("serial")
class IntegrityException extends Exception {
	
	public IntegrityException(String message) {
		super(message);
	}
}

// A class for EmptyPileException
@SuppressWarnings("serial")
class EmptyPileException extends Exception {
	
	public EmptyPileException(String message) {
		super(message);
	}
}

