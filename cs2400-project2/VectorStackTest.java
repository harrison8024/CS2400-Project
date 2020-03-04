/**
A test for VectorStack, which tests for all the methods in the class.
@author Harrison B. Chen
@version 1.0
*/
public class VectorStackTest {

	public static void main(String[] args) {
		// A stack whose initial capacity is small
		StackInterface<String> stackOfElements;
		try {
			stackOfElements = new ArrayStack<>(3);
			testIsEmpty(stackOfElements, true);
			System.out.println("Adding to the stack more strings than its initial capacity.");
			String[] elementsToAdd = {"Element1", "Element2", "Element3", "Element4", "Element5", "Element6", "Element7"};
			testAdd(stackOfElements, elementsToAdd);
			testIsEmpty(stackOfElements, false);
			testGetCurrentSize(stackOfElements, elementsToAdd.length);
			testLook(stackOfElements, elementsToAdd[6]);
			System.out.println("Removing 3 element(s) from the stack.");
			testRemove(stackOfElements, 3);
			testGetCurrentSize(stackOfElements, elementsToAdd.length - 3);
			displayStack(stackOfElements);
			testClear(stackOfElements);
		} catch (IllegalCapacityException e) {
			e.printStackTrace();
		}
	} // end main
	
	// Tests the method push.
	private static void testAdd(StackInterface<String> aStack, String[] content) {
		System.out.print("Adding to the stack: ");
		for(int i = 0; i < content.length; i++) {
			try {
				aStack.push(content[i]);
				System.out.print(content[i] + "  ");
			} catch (IntegrityException e) {
				e.printStackTrace();
			}
		} // end for
		System.out.println();
		displayStack(aStack);
	} // end testAdd
	
	//Tests the method pop.
	private static void testRemove(StackInterface<String> aStack, int numberToRemove) {
		System.out.println("Removing from the stack: ");
		for(int i = 0; i < numberToRemove; i++) {
			try {
				System.out.println(aStack.pop() + " removed from the stack.");
			} catch (IntegrityException | EmptyStackException e) {
				e.printStackTrace();
			}
		}
	} // end testRemove
	
	// Tests the method isEmpty.
	private static void testIsEmpty(StackInterface<String> aStack, boolean correctResult) {
		System.out.print("Testing isEmpty with ");
		if (correctResult) {
			System.out.println("an empty stack:");
		}
	    else {
	    	System.out.println("a stack that is not empty:");
	    	System.out.print("isEmpty finds the stack ");
	    }
    	if (correctResult && aStack.isEmpty()) {
			System.out.println("empty: OK.");
    	}
		else if (correctResult) {
			System.out.println("not empty, but it is empty: ERROR.");
		}
		else if (!correctResult && aStack.isEmpty()) {
			System.out.println("empty, but it is not empty: ERROR.");
		}
		else {
			System.out.println("not empty: OK.");    
		}
		System.out.println();
	} // end testIsEmpty
	
	//Tests the method getCurrentSize.
	private static void testGetCurrentSize(StackInterface<String> aStack, int numberOfElements) {
		int numberInStack = aStack.getCurrentSize();
		if(numberInStack == numberOfElements) {
			System.out.println("The are " + numberInStack + " element(s) in the stack: OK.");
		}
	} // end testGetCurrentSize

	//Tests the method clear.
	private static void testClear(StackInterface<String> aStack) {
		System.out.println("Clearing the stack:");
		aStack.clear();
		testIsEmpty(aStack, true);
	} // end testClear
	
	//Tests the method peek.
	private static void testLook(StackInterface<String> aStack, String elementToCompare) {
		System.out.println("Testing for peek: ");
		try {
			String topElement = aStack.peek();
			System.out.print(topElement + " is the top element: ");
			if(topElement == elementToCompare) {
				System.out.print("Correct.\n");
			}
			else {
				System.out.print("Error.\n");
			}
		} catch (EmptyStackException e) {
			e.printStackTrace();
		}
	}
	
	//Tests the method toArray.
	private static void displayStack(StackInterface<String> aStack)
	{
		System.out.println("The stack contains " + aStack.getCurrentSize() + " string(s), as follows:");		
		Object[] stackArray;
		try {
			stackArray = aStack.toArray();
			for (int i = 0; i < stackArray.length; i++)
			{
				System.out.print(stackArray[i] + "  ");
			} // end for
		} catch (IntegrityException e) {
			e.printStackTrace();
		}	
		System.out.println();
	} // end displayStack
} // end VectorStackTest
