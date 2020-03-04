/** An interface that describes the operations of a stack of objects. */
public interface StackInterface <T> {
	
	/** Gets the current number of entries in this stack.
	@return The integer number of entries currently in the stack. */
	public int getCurrentSize();
	
	/** Detects whether this stack is empty.
	@return True if the stack is empty. */
	public boolean isEmpty();
	
	/** Adds a new entry to the top of this stack.
	@param newEntry An object to be added to the stack.  
	@throws IntegrityException if receiving object is not initialized. */
	public void push(T newEntry) throws IntegrityException;
	
	/** Removes and returns this stack's top entry.
	@return The object at the top of the stack.
	@throws EmptyStackException if the stack is empty before the operation. 
	@throws IntegrityException if receiving object is not initialized. */
	public T pop() throws IntegrityException, EmptyStackException;
	
	/** Return this stack's top entry.
	@return The object at the top of the stack.
	@throws EmptyStackException if the stack is empty. */
	public T peek() throws EmptyStackException;
	
	/** Removes all entries from this stack. */
	public void clear();
	
	/** Returns this stack in an array form.
	@return The array of the objects in the stack. 
	@throws IntegrityException if receiving object is not initialized.
	@throws IntegrityException if receiving object is not initialized. */
	public T[] toArray() throws IntegrityException;
}
