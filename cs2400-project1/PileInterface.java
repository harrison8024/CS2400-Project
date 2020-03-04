/** An interface that describes the operations of a pile of objects. */
public interface PileInterface <T> {
	
	/** Gets the current number of entries in this pile.
	@return The integer number of entries currently in the pile. */
	public int getCurrentSize();
	
	/** Detects whether this pile is empty.
	@return True if the pile is empty. */
	public boolean isEmpty();
	
	/** Adds a new entry to the top of this pile.
	@param newEntry An object to be added to the pile.  
	@throws IntegrityException if receiving object is not initialized. */
	public void add(T newEntry) throws IntegrityException;
	
	/** Removes and returns this pile's top entry.
	@return The object at the top of the pile.
	@throws EmptyStackException if the pile is empty before the operation. 
	@throws IntegrityException if receiving object is not initialized. */
	public T remove() throws IntegrityException, EmptyPileException;
	
	/** Return this pile's top entry.
	@return The object at the top of the stack.
	@throws EmptyStackException if the stack is empty. */
	public T look() throws EmptyPileException;
	
	/** Removes all entries from this pile. */
	public void clear();
	
	/** Returns this pile in an array form.
	@return The array of the objects in the pile. 
	@throws IntegrityException if receiving object is not initialized.
	@throws IntegrityException if receiving object is not initialized. */
	public T[] toArray() throws IntegrityException;
}
