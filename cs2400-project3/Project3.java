import java.util.Scanner;
import java.util.ArrayList;
public class Project3{

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		BinarySearchTree bst = new BinarySearchTree();
		System.out.println("Please enter the initial sequence of values:");
		String input = kb.nextLine();
		Integer[] numbers = stringToArray(input);
		try {
			for(int i = 0; i < numbers.length; i++) {
				bst.add(numbers[i]);
			}
			System.out.print("Pre-order: ");
			bst.preorderTraverse();
			System.out.println();
			System.out.print("In-order: ");
			bst.inorderTraverse();
			System.out.println();
			System.out.print("Post-order: ");
			bst.postorderTraverse();

			char command;
			do {
				System.out.println();
				System.out.print("Command? ");
				command = kb.next().charAt(0);
				int value;
				switch(command) {
					case 'H': case 'h':
						System.out.println("I	Insert a value");
						System.out.println("D	Delete a value");
						System.out.println("E 	Exit the program");
						System.out.println("H 	Display this message");
						break;
					case 'I': case 'i':
						value = kb.nextInt();
						if(bst.contains(value)) {
							System.out.print(value + " already exists, ignore.");
						}
						else {
							bst.add(value);
							System.out.print("In-order: ");
							bst.inorderTraverse();
						}
						break;
					case 'D': case 'd':
						value = kb.nextInt();
						if(!bst.contains(value)) {
							System.out.print(value + " doesn't exist!");
						}
						else {
							bst.remove(value);
							System.out.print("In-order: ");
							bst.inorderTraverse();
						}
						break;
				}
			} while(command != 'E');
			kb.close();
			System.out.println("Thank you for using my program!");
		}catch(EmptyTreeException e) {
			System.out.println("Tree is empty");
		}
		
		
	}

	public static Integer[] stringToArray(String aString) {
		String number = "";
		ArrayList<Integer> numArray = new ArrayList<>();
		for(int i = 0; i < aString.length(); i++) {
			char currentChar = aString.charAt(i);
			if(currentChar != ' ') {
				number += currentChar;
			}
			else {
				numArray.add(Integer.valueOf(number));
				number = "";
			}
			
		}
		numArray.add(Integer.valueOf(number));
		Integer[] intArray = new Integer[numArray.size()];
		intArray = numArray.toArray(intArray);
		return intArray;
	}
}
