/** An interface that describes the operations of a Binary Tree. */
public interface BinaryTreeInterface<T> extends TreeInterface<T> {
	
	
	public void setRootData(T rootData) throws EmptyTreeException;
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) throws UnsupportOperationException;
}
