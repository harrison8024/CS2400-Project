# Binary Search Tree (Integer)

Binary Search Tree is a data structure that can store value in a way that is efficient when doing a search. The left subtree is always less than the root node and the right subtree is always greater than the root node. This version of Binary Search Tree only supports integer.

## How to use?

Create a BinarySearchTree:
```java
BinarySearchTree bst = new BinarySearchTree();
```

There are only 5 functions that a user can use:
1. add
```java
bst.add(10); // add a number to Binary Search Tree
```
2. remove
```java
bst.remove(10); // remove a number from Binary Search Tree
```
3. contains
```java
bst.contains(10); // check if the Binary Search Tree contains a number
```
4. preorderTraverse
```java
bst.preorderTraverse(); // print out numbers in the Binary Search Tree in pre-order sequence
```
5. inorderTraverse
```java
bst.inorderTraverse(); // print out numbers in the Binary Search Tree in in-order sequence
```
6. postorderTraverse
```java
bst.postorderTraverse(); // print out numbers in the Binary Search Tree in ost-order sequence
```

## Client Interface (Project3)

**How to start the program:**
```
java Project3
```
**Start:** User can enter numbers to create a Binary Search Tree
```
Please enter the initial sequence of values:
        (Enter numbers here)
Pre-Order: (Numbers)
In-Order: (Numbers)
Post-Order: (Numbers)
```
**Commands:**
I:  Insert a value
D:  Delete a value
E:  Exit the program
H:  Display this message
```
Command? I (number)
Command? D (number)
Command? E
Command? H
```

## Test

One client file **BinarySearchTreeTest** is used for testing.

```
Testing methods add and method inorderTraverse:
In-Order: 51 
In-Order: 29 51 
In-Order: 29 51 68 
In-Order: 29 51 68 90 
In-Order: 29 36 51 68 90 
In-Order: 29 36 40 51 68 90 
In-Order: 22 29 36 40 51 68 90 
In-Order: 22 29 36 40 51 59 68 90 
In-Order: 22 29 36 40 44 51 59 68 90 
In-Order: 22 29 36 40 44 51 59 68 90 99 
In-Order: 22 29 36 40 44 51 59 68 77 90 99 
In-Order: 22 29 36 40 44 51 59 60 68 77 90 99 
In-Order: 22 27 29 36 40 44 51 59 60 68 77 90 99 
In-Order: 22 27 29 36 40 44 51 59 60 68 77 83 90 99 
In-Order: 15 22 27 29 36 40 44 51 59 60 68 77 83 90 99 
In-Order: 15 22 27 29 36 40 44 51 59 60 68 75 77 83 90 99 
In-Order: 3 15 22 27 29 36 40 44 51 59 60 68 75 77 83 90 99 
Testing method remove:
Removed 90.
In-Order: 3 15 22 27 29 36 40 44 51 59 60 68 75 77 83 99 Testing method contains:
Does BST contain number 70? No, Correct
Does BST contain number 3? Yes, Correct
Testing methods preorderTraverse and postorderTraverse:
Pre-Order: 51 29 22 15 3 27 36 40 44 68 59 60 83 77 75 99 
Post-Order: 3 15 27 22 44 40 36 29 60 59 75 77 99 83 68 51 
```

## Author

Harrison B. Chen

## IDE

Eclipse 2019-03




