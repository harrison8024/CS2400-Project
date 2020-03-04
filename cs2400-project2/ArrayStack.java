import java.util.Arrays;

/**
	A class that implements a Stack by using an array.
	The Stack has no maximum and can only push and pop from the top.
	@author Harrison B. Chen
	@version 1.0
*/
public final class ArrayStack<T> implements StackInterface<T> {
	
	private T[] stack; // Cannot be final due to doubling
	private int topIndex;
	private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 50; // Initial capacity of stack
	private static final int MAX_CAPACITY = 10000;
	
	/** Creates an empty stack whose initial capacity is 50. */
	public ArrayStack() throws IllegalCapacityException {
		this(DEFAULT_CAPACITY);
	} // end default constructor
	
	/** Creates an empty stack having a given initial capacity.
	 	@param initialCapacity
	 	@throws IllegalCapacityException if initialCapacity is larger than MAX_CAPACITY  */
	public ArrayStack(int initialCapacity) throws IllegalCapacityException {
		integrityOK = false;
		checkCapacity(initialCapacity);
		
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[initialCapacity]; // Unchecked cast
		stack = tempStack;
		topIndex = -1;
		integrityOK = true;
		
	} // end constructor
	
	/** Adds a new entry to this stack.
    @param newEntry  The object to be added as a new entry.
    @throws IntegrityException if receiving object is not initialized */
	public void push(T newEntry) throws IntegrityException {
		checkIntegrity();
		ensureCapacity();
		
		stack[topIndex + 1] = newEntry;
		topIndex++;
	} // end push
	
	/** Removes the top entry from this stack.
    @return  the entry that is being removed */
	public T pop() throws IntegrityException, EmptyStackException {
		checkIntegrity();
		
		if(!isEmpty()) {
			T result = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
			return result;
		}
		else {
			throw new EmptyStackException("Stack is Empty, can not perform pop.");
		}
	} // end pop
	
	/** Return this stack's top entry.
	@return The object at the top of the stack.
	@throws EmptyStackException if the stack is empty. */
	public T peek() throws EmptyStackException{
		if(!isEmpty()) {
			return stack[topIndex];
		}
		else {
			throw new EmptyStackException("Stack is Empty, can not perform peek.");
		}
	} // end peek
	
	/** Gets the current number of entries in this stack.
    @return  The integer number of entries currently in this stack. */
	public int getCurrentSize() {
		return topIndex + 1;
	} // end getCurrentSize
	
	/** Sees whether this stack is empty.
    @return  True if this stack is empty, or false if not. */
	public boolean isEmpty() {
		return topIndex == -1;
	} // end isEmpty
	
	/** Clear all entries in the stack. */
	public void clear() {
		integrityOK = false;
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[DEFAULT_CAPACITY];
		stack = tempStack;
		topIndex = -1;
		integrityOK = true;
	} // end clear
	
	/** Returns this stack in an array form.
	@return The array of the objects in the stack. 
	@throws IntegrityException if receiving object is not initialized。 */
	public T[] toArray() throws IntegrityException {
		checkIntegrity();
		
		// The cast is safe because the new array contains null entries.
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[topIndex + 1]; // Unchecked cast
		if(!isEmpty()) {
			for (int i = 0; i <= topIndex; i++) {
				result[i] = stack[i];
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
	
	// Double the array when the stack reach the capacity limit.
	private void ensureCapacity() {
		if(topIndex == stack.length - 1) {
			stack = Arrays.copyOf(stack, 2 * stack.length);
		}
	} // end ensureCapacity
} // end ArrayStack

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

// A class for EmptyStackException
@SuppressWarnings("serial")
class EmptyStackException extends Exception {
	
	public EmptyStackException(String message) {
		super(message);
	}
}

