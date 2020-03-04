public class BinarySearchTree extends BinaryTree implements SearchTreeInterface<Integer> {

	public BinarySearchTree() {
		super();
	}

	public BinarySearchTree(int rootData) {
		super(rootData);
	}
	
	public void setTree(Integer rootData, BinaryTreeInterface<Integer> leftTree, BinaryTreeInterface<Integer> rightTree) throws UnsupportOperationException {
		throw new UnsupportOperationException("setTree disabled");
	}

	@Override
	public boolean contains(Integer anEntry) throws EmptyTreeException {
		return getEntry(anEntry) != null;
	}

	@Override
	public Integer getEntry(Integer anEntry) throws EmptyTreeException {
		return findEntry(getRootNode(), anEntry);
	} // end getEntry
	
	private Integer findEntry(BinaryNode rootNode, int anEntry) {
		Integer result = null;
		if(rootNode != null) {
			int rootEntry = rootNode.getData();
			if(anEntry == rootEntry) {
				result = rootEntry;
			}
			else if(anEntry < rootEntry) {
				result = findEntry(rootNode.getLeftChild(), anEntry);
			}
			else {
				result = findEntry(rootNode.getRightChild(), anEntry);
			}
		} // end if
		return result;
	} // end findEntry

	@Override
	public Integer add(Integer anEntry) throws EmptyTreeException {
		Integer result = null;
		if(isEmpty()) {
			setRootNode(new BinaryNode(anEntry));
		}
		else {
			result = addEntry(getRootNode(), anEntry);
		}
		return result;
	}
	
	private Integer addEntry(BinaryNode rootNode, int anEntry) {
		assert rootNode != null;
		Integer result = null;
		int rootNodeData = rootNode.getData();
		if(anEntry == rootNodeData) {
			result = rootNodeData;
			rootNode.setData(anEntry);
		}
		else if(anEntry < rootNodeData) {
			if(rootNode.hasLeftChild()) {
				result = addEntry(rootNode.getLeftChild(), anEntry);
			}
			else {
				rootNode.setLeftChild(new BinaryNode(anEntry));
			}
		}
		else {
			assert anEntry > rootNodeData;
			if(rootNode.hasRightChild()) {
				result = addEntry(rootNode.getRightChild(), anEntry);
			}
			else {
				rootNode.setRightChild(new BinaryNode(anEntry));
			}
		}
		return result;
	} // end addEntry

	@Override
	public Integer remove(Integer anEntry) throws EmptyTreeException {
		@SuppressWarnings("null")
		ReturnObject<Integer> oldEntry = new ReturnObject<>(null);
		BinaryNode newRoot = removeEntry(getRootNode(), anEntry, oldEntry);
		setRootNode(newRoot);
		return oldEntry.get();
	} // end remove

	private BinaryNode removeEntry(BinaryNode rootNode, Integer anEntry, ReturnObject<Integer> oldEntry) {
		if(rootNode != null) {
			int rootData = rootNode.getData();
			if(anEntry == rootData) {
				oldEntry.set(rootData);
				rootNode = removeFromRoot(rootNode);
			}
			else if(anEntry < rootData) {
				BinaryNode leftChild = rootNode.getLeftChild();
				BinaryNode subtreeRoot = removeEntry(leftChild, anEntry, oldEntry);
				rootNode.setLeftChild(subtreeRoot);
			}
			else {
				BinaryNode rightChild = rootNode.getRightChild();
				BinaryNode subtreeRoot = removeEntry(rightChild, anEntry, oldEntry);
				rootNode.setRightChild(subtreeRoot);
			}
		}
		return rootNode;
	}
	
	private BinaryNode removeFromRoot(BinaryNode rootNode) {
		if(rootNode.hasLeftChild() && rootNode.hasRightChild()) {
			BinaryNode leftSubtreeRoot = rootNode.getLeftChild();
			BinaryNode largestNode = findLargest(leftSubtreeRoot);
			
			rootNode.setData(largestNode.getData());
			
			rootNode.setLeftChild(removeLargest(leftSubtreeRoot));
		}
		else if(rootNode.hasRightChild()) {
			rootNode = rootNode.getRightChild();
		}
		else {
			rootNode = rootNode.getLeftChild();
		}
		return rootNode;
	}
	
	private BinaryNode findLargest(BinaryNode rootNode) {
		if(rootNode.hasRightChild()) {
			rootNode = findLargest(rootNode.getRightChild());
		}
		return rootNode;
	}
	
	private BinaryNode removeLargest(BinaryNode rootNode) {
		if(rootNode.hasRightChild()) {
			BinaryNode rightChild = rootNode.getRightChild();
			rightChild = removeLargest(rightChild);
			rootNode.setRightChild(rightChild);
		}
		else {
			rootNode = rootNode.getLeftChild();
		}
		return rootNode;
	}
	
	@Override
	public void preorderTraverse() throws EmptyTreeException {
		preorderTraverse(getRootNode());
	}
	
	private void preorderTraverse(BinaryNode node) {
		if(node != null) {
			System.out.print(node.getData() + " ");
			preorderTraverse(node.getLeftChild());
			preorderTraverse(node.getRightChild());
		}
	}

	@Override
	public void inorderTraverse() throws EmptyTreeException {
		inorderTraverse(getRootNode());
	}
	
	private void inorderTraverse(BinaryNode node) {
		if(node != null) {
			inorderTraverse(node.getLeftChild());
			System.out.print(node.getData() + " ");
			inorderTraverse(node.getRightChild());
		}
	}

	@Override
	public void postorderTraverse() throws EmptyTreeException {
		postorderTraverse(getRootNode());
	}
	
	private void postorderTraverse(BinaryNode node) {
		if(node != null) {
			postorderTraverse(node.getLeftChild());
			postorderTraverse(node.getRightChild());
			System.out.print(node.getData() + " ");
		}
	}

} // end BinarySearTree

class ReturnObject<T>{
	private T object;
	
	public ReturnObject(T newObject){
		set(newObject);
	}
	
	public void set(T newObject) {
		object = newObject;
	}
	
	public T get() {
		return object;
	}
	
}