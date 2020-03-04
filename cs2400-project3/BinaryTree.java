public class BinaryTree implements BinaryTreeInterface<Integer> {
	private BinaryNode root;
	
	public BinaryTree() {
		root = null;
	}
	
	public BinaryTree(Integer rootData) {
		root = new BinaryNode(rootData);
	}
	
	public BinaryTree(Integer rootData, BinaryTree leftTree, BinaryTree rightTree) {
		initializeTree(rootData, leftTree, rightTree);
	}
	
	public void setRootData(Integer rootData) throws EmptyTreeException {
		if(!isEmpty()) {
			root.setData(rootData);
		}
		else {
			throw new EmptyTreeException("Tree is Empty.");
		}
	}
	
	public void setRootNode(BinaryNode newNode) {
		root = newNode;
	}
	
	public void setTree(Integer rootData, BinaryTreeInterface<Integer> leftTree, BinaryTreeInterface<Integer> rightTree) throws UnsupportOperationException {
		initializeTree(rootData, (BinaryTree)leftTree, (BinaryTree)rightTree);
	}
	
	private void initializeTree(Integer rootData, BinaryTree leftTree, BinaryTree rightTree) {
		root = new BinaryNode(rootData);
		if((leftTree != null) && (!leftTree.isEmpty())) {
			root.setLeftChild(leftTree.root);
		}
		if((rightTree != null) && (!rightTree.isEmpty())) {
			if(rightTree != leftTree) {
				root.setRightChild(rightTree.root);
			}
			else {
				root.setRightChild(rightTree.root.copy());
			}
		}
		if((leftTree != null) && (leftTree != this)) {
			leftTree.clear();
		}
		if((rightTree != null) && (rightTree != this)) {
			rightTree.clear();
		}
		
	}
	
	public Integer getRootData() throws EmptyTreeException {
		if(!isEmpty()) {
			return root.getData();
		}
		else {
			throw new EmptyTreeException("Tree is Empty.");
		}
	}
	
	public BinaryNode getRootNode() throws EmptyTreeException {
		if(!isEmpty()) {
			return root;
		}
		else {
			throw new EmptyTreeException("Tree is Empty.");
		}
	}
	
	public int getHeight() {
		return root.getHeight();
	}
	
	public int getNumberOfNodes() {
		return root.getNumberOfNodes();
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void clear() {
		root = null;
	}
	
	public class BinaryNode {
		private int data;
		private BinaryNode leftChild;
		private BinaryNode rightChild;
		
		public BinaryNode() {
			this(0);
		}
		
		public BinaryNode(int dataPortion) {
			this(dataPortion, null, null);
		}
		
		public BinaryNode(int dataPortion, BinaryNode newLeftChild, BinaryNode newRightChild) {
			data = dataPortion;
			leftChild = newLeftChild;
			rightChild = newRightChild;
		}
		
		public int getData() {
			return data;
		}
		
		public void setData(int newData) {
			data = newData;
		}
		
		public BinaryNode getLeftChild() {
			return leftChild;
		}
		
		public BinaryNode getRightChild() {
			return rightChild;
		}
		
		public void setLeftChild(BinaryNode newLeftChild) {
			leftChild = newLeftChild;
		}
		
		public void setRightChild(BinaryNode newRightChild) {
			rightChild = newRightChild;
		}
		
		public boolean hasLeftChild() {
			return leftChild != null;
		}
		
		public boolean hasRightChild() {
			return rightChild != null;
		}
		
		public boolean isLeaf() {
			return (leftChild == null) && (rightChild == null);
		}
		
		public int getNumberOfNodes() {
			int leftNumber = 0;
			int rightNumber = 0;
			if(leftChild != null) {
				leftNumber = leftChild.getNumberOfNodes();
			}
			if(rightChild != null) {
				rightNumber = rightChild.getNumberOfNodes();
			}
			return 1 + leftNumber + rightNumber;
		}
		
		public int getHeight() {
			return getHeight(this);
		}
		
		public int getHeight(BinaryNode node) {
			int height = 0;
			if(node != null) {
				height = 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
			}
			return height;
		}
		
		public BinaryNode copy() {
			BinaryNode newRoot = new BinaryNode(data);
			if(leftChild != null) {
				newRoot.setLeftChild(leftChild.copy());
			}
			if(rightChild != null) {
				newRoot.setRightChild(rightChild.copy());
			}
			return newRoot;
		}
	}
}
