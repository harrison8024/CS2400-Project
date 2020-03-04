/**
A class of Stack whose entries are stored in a chain of linked nodes.
The Stack has no maximum limit but can only push and pop from the top.
@author Harrison B. Chen
@version 1.0
*/
public final class LinkedStack<T> implements StackInterface<T>{
	
	private Node topNode;			// Reference to first node
	private int numberOfEntries;
	
	/** Creates an empty stack. */
	public LinkedStack() {
		topNode = null;
		numberOfEntries = 0;
	} // end default constructor
	
	/** Creates a stack with one entry. */
	public LinkedStack(T newEntry) {
		push(newEntry);
	} // end constructor
	
	/** Adds a new entry to this stack.
    @param newEntry  The object to be added as a new entry
    @return  True if the addition is successful, or false if not. */
	public void push(T newData) {
		Node newNode = new Node(newData);
		newNode.setNextNode(topNode);
		topNode = newNode;
		numberOfEntries++;
	} // end constructor
	
	/** Removes the top entry from this stack, if possible.
    @return Either the removed entry, if the removal was successful, or null. 
    @throws EmptyStackException if the stack is empty.  */
	public T pop() throws EmptyStackException {
		if(!isEmpty()) {
			T result = topNode.getData();
			topNode = topNode.getNextNode();
			numberOfEntries--;
			return result;
		}
		else {
			throw new EmptyStackException("Stack is empty, cannot perform pop.");			
		}
	} // end pop
	
	/** Return this stack's top entry.
	@return The object at the top of the stack
	@throws EmptyStackException if the stack is empty. */
	public T peek() throws EmptyStackException {
		if(!isEmpty()) {
			return topNode.getData();
		}
		else {
			throw new EmptyStackException("Stack is empty, cannot perform peek.");
		}
	} // end peek
	
	/** Removes all entries from this stack. */
	public void clear() {
		topNode = null;
		numberOfEntries = 0;
	} // end clear
	
	/** Sees whether this stack is empty.
    @return  True if this stack is empty, or false if not. */
	public boolean isEmpty() {
		return numberOfEntries == 0;
	} // end isEmpty
	
	/** Gets the number of entries currently in this stack.
    @return  The integer number of entries currently in this stack. */
	public int getCurrentSize() {
		return numberOfEntries;
	} // end getCurrentSize
	
	/** Returns this stack in an array form.
	@return The array of the objects in the stack. */
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];
		int index = 0;
    	Node currentNode = topNode;
    	while ((index < numberOfEntries) && (currentNode != null)) {
    		result[index] = currentNode.getData();
    		index++;
    		currentNode = currentNode.getNextNode();
    	} // end while
		return result;
	} // end toArray
	
	/** A class that creates linked nodes that holds the data and the reference of the next node */
	private class Node {
		private T data;
		private Node next;
		
		/** Creates an empty Node*/
		public Node() {
			this(null);
		} // end default constructor
		
		/** Creates a Node with newEntry*/
		public Node(T newEntry) {
			setData(newEntry);
			next = null;
		} // end constructor
		
		/** Return the data of the Node
		@return The value in data*/
		public T getData() {
			return data;
		} // end getData
		
		public void setData(T newData) {
			data = newData;
		} // end setData
		
		public Node getNextNode() {
			return next;
		} // end getNextNode
		
		public void setNextNode(Node newNode) {
			next = newNode;
		} // end setNextNode
	} // end Node
} // end LinkedStack