/**
A test for LinkedPile, which tests for all the method in the class.
@author Harrison B. Chen
@version 1.0
*/
public class LinkedPileDemo {

	public static void main(String[] args) throws IntegrityException {
		// A pile whose initial capacity is small
		PileInterface<String> pileOfBooks;
		pileOfBooks = new LinkedPile<>();
		testIsEmpty(pileOfBooks, true);
		System.out.println("Adding to the pile more strings than its initial capacity.");
		String[] booksToAdd = {"Book1", "Book2", "Book3", "Book4", "Book5", "Book6", "Book7"};
		testAdd(pileOfBooks, booksToAdd);
		testIsEmpty(pileOfBooks, false);
		testGetCurrentSize(pileOfBooks, booksToAdd.length);
		testLook(pileOfBooks, booksToAdd[6]);
		System.out.println("Removing 3 book from the pile.");
		testRemove(pileOfBooks, 3);
		testGetCurrentSize(pileOfBooks, booksToAdd.length - 3);
		displayPile(pileOfBooks);
		testClear(pileOfBooks);
	} // end main
	
	// Tests the method add.
	private static void testAdd(PileInterface<String> aPile, String[] content) throws IntegrityException {
		System.out.print("Adding to the pile: ");
		for(int i = 0; i < content.length; i++) {
				aPile.add(content[i]);
				System.out.print(content[i] + "  ");
		} // end for
		System.out.println();
		displayPile(aPile);
	} // end testAdd
	
	// Tests the method remove
	private static void testRemove(PileInterface<String> aPile, int numberToRemove) {
		System.out.println("Removing from the pile: ");
		for(int i = 0; i < numberToRemove; i++) {
			try {
				System.out.println(aPile.remove() + " removed from the pile.");
			} catch (IntegrityException | EmptyPileException e) {
				e.printStackTrace();
			}
		}
	} // end testRemove
	
	// Tests the method isEmpty.
	private static void testIsEmpty(PileInterface<String> aPile, boolean correctResult) {
		System.out.print("Testing isEmpty with ");
		if (correctResult) {
			System.out.println("an empty pile:");
		}
	    else {
	    	System.out.println("a pile that is not empty:");
	    	System.out.print("isEmpty finds the pile ");
	    }
    	if (correctResult && aPile.isEmpty()) {
			System.out.println("empty: OK.");
    	}
		else if (correctResult) {
			System.out.println("not empty, but it is empty: ERROR.");
		}
		else if (!correctResult && aPile.isEmpty()) {
			System.out.println("empty, but it is not empty: ERROR.");
		}
		else {
			System.out.println("not empty: OK.");    
		}
		System.out.println();
	} // end testIsEmpty
	
	// Tests the method getCurrentSize.
	private static void testGetCurrentSize(PileInterface<String> aPile, int numberOfBooks) {
		int numberInPile = aPile.getCurrentSize();
		if(numberInPile == numberOfBooks) {
			System.out.println("The are " + numberInPile + " Book(s) in the pile: OK.");
		}
	} // end testGetCurrentSize

	//Tests the method clear
	private static void testClear(PileInterface<String> aPile) {
		System.out.println("Clearing the pile:");
		aPile.clear();
		testIsEmpty(aPile, true);
	} // end testClear
	
	//Test the method look
	private static void testLook(PileInterface<String> aPile, String bookToCompare) {
		System.out.println("Testing for look: ");
		try {
			String topBook = aPile.look();
			System.out.print(topBook + " is the top Book: ");
			if(topBook == bookToCompare) {
				System.out.print("Correct.\n");
			}
			else {
				System.out.print("Error.\n");
			}
		} catch (EmptyPileException e) {
			e.printStackTrace();
		}
	}
	
	//Tests the method toArray.
	private static void displayPile(PileInterface<String> aPile)
	{
		System.out.println("The pile contains " + aPile.getCurrentSize() + " string(s), as follows:");		
		Object[] pileArray;
		try {
			pileArray = aPile.toArray();
			for (int i = 0; i < pileArray.length; i++)
			{
				System.out.print(pileArray[i] + "  ");
			} // end for
		} catch (IntegrityException e) {
			e.printStackTrace();
		}	
		System.out.println();
	} // end displayPile
} // end LinkedPileDemo
