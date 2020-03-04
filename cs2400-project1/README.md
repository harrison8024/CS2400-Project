# PileOfBooks

PileOfBooks is a data structure which mimics a pile of books in real life where you can only put and remove books from the top, but not from the middle. There are two types of PileOfBooks: ArrayPile and LinkedPile.

## Pile

Pile is a data structure that is similar to stack, where you use push, pop, and peek methods (Pile uses add, remove, and look methods) to manipulate the data.

## How to use?

Create a pileOfBooks:
```java
ArrayPile<String> pileOfBooks = new ArrayPile<String>(); // Array
LinkedPile<String> pileOfBooks = new LinkedPile<String>(); // Linked-Chain
```

There are only 5 functions that a user can use:
1. add
```java
pileOfBooks.add("NameOFBook"); // add to the top of pile
```
2. remove
```java
pileOfBooks.remove(); // remove from the top of pile
```
3. getCurrentSize
```java
pileOfBooks.getCurrentSize(); // return the number of books in the pile
```
4. isEmpty
```java
pilOfBooks.isEmpty(); // check if the pile is empty or not
```
5. clear
```java
pileOfBooks.clear(); // remove all the books from the pile
```

## Test

Two client file **ArrayPileDemo** and **LinkedPileDemo** is used for testing.

```
Testing isEmpty with an empty pile:
empty: OK.

Adding to the pile more strings than its initial capacity.
Adding to the pile: Book1  Book2  Book3  Book4  Book5  Book6  Book7  
The pile contains 7 string(s), as follows:
Book1  Book2  Book3  Book4  Book5  Book6  Book7  
Testing isEmpty with a pile that is not empty:
isEmpty finds the pile not empty: OK.

The are 7 Book(s) in the pile: OK.
Testing for look: 
Book7 is the top Book: Correct.
Removing 3 book from the pile.
Removing from the pile: 
Book7 removed from the pile.
Book6 removed from the pile.
Book5 removed from the pile.
The are 4 Book(s) in the pile: OK.
The pile contains 4 string(s), as follows:
Book1  Book2  Book3  Book4  
Clearing the pile:
Testing isEmpty with an empty pile:
empty: OK.
```

##### LinkedPileDemo


## Author

Harrison B. Chen

## IDE

Eclipse 2019-03




