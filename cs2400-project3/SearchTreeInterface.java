public interface SearchTreeInterface<T> extends TreeInterface<T> {
	public boolean contains(T anEntry) throws EmptyTreeException;
	public T getEntry(T anEntry) throws EmptyTreeException;
	public T add(T anEntry) throws EmptyTreeException;
	public T remove(T anEntry) throws EmptyTreeException;
	public void preorderTraverse() throws EmptyTreeException;
	public void inorderTraverse() throws EmptyTreeException;
	public void postorderTraverse() throws EmptyTreeException;
}