/**
A class of Pile whose entries are stored in a chain of linked nodes.
The Pile has no maximum limit but can only add and remove from the top.
@author Harrison B. Chen
@version 1.0
*/
public final class LinkedPile<T> implements PileInterface<T>{
	
	private Node topNode;			// Reference to first node
	private int numberOfEntries;
	
	/** Creates an empty pile. */
	public LinkedPile() {
		topNode = null;
		numberOfEntries = 0;
	} // end default constructor
	
	/** Creates a pile with one entry. */
	public LinkedPile(T newEntry) {
		add(newEntry);
	} // end constructor
	
	/** Adds a new entry to this pile.
    @param newEntry  The object to be added as a new entry
    @return  True if the addition is successful, or false if not. */
	public void add(T newData) {
		Node newNode = new Node(newData);
		newNode.setNextNode(topNode);
		topNode = newNode;
		numberOfEntries++;
	} // end constructor
	
	/** Removes the top entry from this pile, if possible.
    @return Either the removed entry, if the removal was successful, or null. 
    @throws EmptyPileException if the pile is empty.  */
	public T remove() throws EmptyPileException {
		if(!isEmpty()) {
			T result = topNode.getData();
			topNode = topNode.getNextNode();
			numberOfEntries--;
			return result;
		}
		else {
			throw new EmptyPileException("Pile is empty, cannot perform remove.");			
		}
	} // end remove
	
	/** Return this pile's top entry.
	@return The object at the top of the pile
	@throws EmptyStackException if the pile is empty. */
	public T look() throws EmptyPileException {
		if(!isEmpty()) {
			return topNode.getData();
		}
		else {
			throw new EmptyPileException("Pile is empty, cannot perform look.");
		}
	} // end look
	
	/** Removes all entries from this pile. */
	public void clear() {
		topNode = null;
		numberOfEntries = 0;
	} // end clear
	
	/** Sees whether this pile is empty.
    @return  True if this pile is empty, or false if not. */
	public boolean isEmpty() {
		return numberOfEntries == 0;
	} // end isEmpty
	
	/** Gets the number of entries currently in this pile.
    @return  The integer number of entries currently in this pile. */
	public int getCurrentSize() {
		return numberOfEntries;
	} // end getCurrentSize
	
	/** Returns this pile in an array form.
	@return The array of the objects in the pile. */
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
} // end LinkedPile