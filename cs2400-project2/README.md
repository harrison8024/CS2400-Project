# stackOfelements

stackOfelements is a data structure which mimics a stack of elements in real life where you can only put and remove elements from the top, but not from the middle. 
There are two types of stackOfelements: ArrayStack, LinkedStack and VectorStack.

## stack

Stack is a data structure that is similar to stack, where you use push, pop, and peek methods (stack uses add, remove, and look methods) to manipulate the data.

## How to use?

Create a stackOfElements:
```java
ArrayStack<String> stackOfElements = new ArrayStack<String>(); // Array
LinkedStack<String> stackOfElements = new LinkedStack<String>(); // Linked-Chain
VectorStack<String> stackOfElements = new VectorStack<String>(); // Vector
```

There are only 5 functions that a user can use:
1. add
```java
stackOfElements.add("NameOFelement"); // add to the top of stack
```
2. remove
```java
stackOfElements.remove(); // remove from the top of stack
```
3. getCurrentSize
```java
stackOfElements.getCurrentSize(); // return the number of elements in the stack
```
4. isEmpty
```java
pilOfElements.isEmpty(); // check if the stack is empty or not
```
5. clear
```java
stackOfElements.clear(); // remove all the elements from the stack
```

## Test

Two client file **ArrayStackTest**, **LinkedStackTest** and **VectorStackTest** is used for testing.

```
Testing isEmpty with an empty stack:
empty: OK.

Adding to the stack more strings than its initial capacity.
Adding to the stack: Element1  Element2  Element3  Element4  Element5  Element6  Element7  
The stack contains 7 string(s), as follows:
Element1  Element2  Element3  Element4  Element5  Element6  Element7  
Testing isEmpty with a stack that is not empty:
isEmpty finds the stack not empty: OK.

The are 7 Element(s) in the stack: OK.
Testing for peek: 
Element7 is the top Element: Correct.
Removing 3 element(s) from the stack.
Removing from the stack: 
Element7 removed from the stack.
Element6 removed from the stack.
Element5 removed from the stack.
The are 4 Element(s) in the stack: OK.
The stack contains 4 string(s), as follows:
Element1  Element2  Element3  Element4  
Clearing the stack:
Testing isEmpty with an empty stack:
empty: OK.

```

## Author

Harrison B. Chen

## IDE

Eclipse 2019-03




