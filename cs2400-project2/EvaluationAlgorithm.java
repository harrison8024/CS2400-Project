
public class EvaluationAlgorithm {

	public static void main(String[] args) {
		System.out.println("Answer:" + evaluateInfix("(d*f)+e*f/(a+b*c)"));
	}

	public static int evaluateInfix(String infix) {
		
		LinkedStack<Character> operatorStack = new LinkedStack<>(); 
		LinkedStack<Integer> valueStack = new LinkedStack<>();
		
		int index = 0;
		while(index < infix.length()) {
			char nextCharacter = infix.charAt(index);
			switch(nextCharacter) {
				case 'a': case 'b': case 'c': case 'd': case 'e': case 'f':
					valueStack.push(getValue(nextCharacter));
					break;
					
				case '^':
					operatorStack.push(nextCharacter);
					break;
					
				case '+': case '-': case '*': case '/':
					try {
						while(!operatorStack.isEmpty() && getPrecedence(nextCharacter) <= getPrecedence(operatorStack.peek())) {
							//Execute operator at top of operatorStack
							char topOperator = operatorStack.pop();
							int operandTwo = valueStack.pop();
							int operandOne = valueStack.pop();
							int result = calculate(topOperator, operandOne, operandTwo);
							valueStack.push(result);
						}
						operatorStack.push(nextCharacter);
					} catch (EmptyStackException e) {
						e.printStackTrace();
					}
					break;
				
				case '(':
					operatorStack.push(nextCharacter);
					break;
				case ')':
				try {
					char topOperator = operatorStack.pop();
					while(topOperator != '(') {
						int operandTwo = valueStack.pop();
						int operandOne = valueStack.pop();
						int result = calculate(topOperator, operandOne, operandTwo);
						valueStack.push(result);
						topOperator = operatorStack.pop();
					}
				} catch (EmptyStackException e) {
					e.printStackTrace();
				}
				default:
					break;
			}
			index++;
		}
		int answer = 0;
		try {
			while(!operatorStack.isEmpty()) {
				char topOperator = operatorStack.pop();
				int operandTwo = valueStack.pop();
				int operandOne = valueStack.pop();
				int result = calculate(topOperator, operandOne, operandTwo);
				valueStack.push(result);
			}
			answer = valueStack.peek();
		} catch (EmptyStackException e) {
			e.printStackTrace();
		}
		return answer;
	}
	
	public static int getPrecedence(char operator) {
		int result = 0;
		switch(operator) {
			case '+': case '-':
				result = 1;
				break;
			case '*': case '/':
				result = 2;
				break;
			case '^':
				result = 3;
				break;
			case '(':
				result = 0;
				break;
			default: 
				break;
		}
		return result;
	}
	
	public static int getValue(char operand) {
		int result = 0;
		switch(operand) {
			case 'a':
				result = 2;
				break;
			case 'b':
				result = 3;
				break;
			case 'c':
				result = 4;
				break;
			case 'd':
				result = 5;
				break;
			case 'e':
				result = 6;
				break;
			case 'f':
				result = 7;
				break;
			default:
				break;
		}
		return result;	
	}
	
	public static int calculate(char operator, int valueOne, int valueTwo) {
		int result = 0;
		switch(operator) {
			case '+':
				result = valueOne + valueTwo;
				break;
			case '-':
				result = valueOne - valueTwo;
				break;
			case '*':
				result = valueOne * valueTwo;
				break;
			case '/':
				result = valueOne / valueTwo;
				break;
			case '^':
				result = (int) Math.pow(valueOne, valueTwo);
				break;
			default:
				break;
		}
		return result;
	}
}
