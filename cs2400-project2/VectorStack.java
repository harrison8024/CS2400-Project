import java.util.Vector;

/**
A class that implements a Stack by using Vectors.
The Stack has no maximum and can only push and pop from the top.
@author Harrison B. Chen
@version 1.0
*/
public class VectorStack<T> implements StackInterface<T> {
	
	private Vector<T> stack;	// Cannot be final due to doubling
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	private static boolean integrityOK = false;
	
	public VectorStack() throws IllegalCapacityException{
		this(DEFAULT_CAPACITY);
	}
	
	public VectorStack(int initialCapacity) throws IllegalCapacityException {
		
		checkCapacity(initialCapacity);
		integrityOK = false;
		stack = new Vector<>(initialCapacity);
		integrityOK = true;
		
	}
	
	/** Gets the current number of entries in this stack.
	@return The integer number of entries currently in the stack. */
	public int getCurrentSize() {
		return stack.size();
	}
	
	/** Detects whether this stack is empty.
	@return True if the stack is empty. */
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	/** Adds a new entry to the top of this stack.
	@param newEntry An object to be added to the stack.  
	@throws IntegrityException if receiving object is not initialized. */
	public void push(T newEntry) throws IntegrityException {
		checkIntegrity();
		ensureCapacity();
		stack.add(newEntry);
	}
	
	/** Removes and returns this stack's top entry.
	@return The object at the top of the stack.
	@throws EmptyStackException if the stack is empty before the operation. 
	@throws IntegrityException if receiving object is not initialized. */
	public T pop() throws IntegrityException, EmptyStackException {
		checkIntegrity();
		if(!isEmpty()) {
			int lastIndex = stack.size() - 1;
			T result = stack.get(lastIndex);
			stack.remove(lastIndex);
			return result;
		}
		else {
			throw new EmptyStackException("Stack is Empty, can not perform pop.");
		}
	}
	
	/** Return this stack's top entry.
	@return The object at the top of the stack.
	@throws EmptyStackException if the stack is empty. */
	public T peek() throws EmptyStackException {
		if(!isEmpty()) {
			return stack.lastElement();
		}
		else {
			throw new EmptyStackException("Stack is Empty, can not perform peek.");
		}
	}
	
	/** Removes all entries from this stack. */
	public void clear() {
		stack.clear();
	}
	
	/** Returns this stack in an array form.
	@return The array of the objects in the stack. 
	@throws IntegrityException if receiving object is not initialized. */
	public T[] toArray() throws IntegrityException {
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) stack.toArray();
		return tempStack;
	}
	
	// Double the array when the stack reach the capacity limit.
	private void ensureCapacity() {
		stack.ensureCapacity(stack.size() + 1);
	} // end ensureCapacity
	
	// Throws an exception if receiving object is not initialized.
		private void checkIntegrity() throws IntegrityException {
			if(!integrityOK) {
				throw new IntegrityException("Integrity not OK");
			}
		} // end checkIntegrity
	
	// Throws an exception if the client requests a capacity that is too large.
	private void checkCapacity(int capacity) throws IllegalCapacityException {
		if(capacity < 0 || capacity > MAX_CAPACITY) {
			throw new IllegalCapacityException("capacity exceed Max Capacity");
		}
	} // end checkCapacity
}
