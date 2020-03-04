
public class BinarySearchTreeTest {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		try {
			System.out.println("Testing methods add and method inorderTraverse:");
			int[] numberToAdd = {51, 29, 68, 90, 36, 40, 22, 59, 44, 99, 77, 60, 27, 83, 15, 75, 3};
			for(int i = 0; i < numberToAdd.length; i++) {
				bst.add(numberToAdd[i]);
				System.out.print("In-Order: ");
				bst.inorderTraverse();
				System.out.println();
			}
			
			System.out.println("Testing method remove:");
			bst.remove(90);
			System.out.println("Removed 90.");
			System.out.print("In-Order: ");
			bst.inorderTraverse();
			
			System.out.println("Testing method contains:");
			System.out.print("Does BST contain number 70? ");
			if(!bst.contains(70)) {
				System.out.println("No, Correct");
			}
			
			System.out.print("Does BST contain number 3? ");
			if(bst.contains(3)) {
				System.out.println("Yes, Correct");
			}
			
			System.out.println("Testing methods preorderTraverse and postorderTraverse:");
			System.out.print("Pre-Order: ");
			bst.preorderTraverse();
			System.out.println();
			System.out.print("Post-Order: ");
			bst.postorderTraverse();
		} catch (EmptyTreeException e) {
			e.printStackTrace();
		}
		
	}

}
