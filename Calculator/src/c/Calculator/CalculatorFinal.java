package c.Calculator;

import java.util.Stack;
import java.util.Scanner;

public class CalculatorFinal {
	static Stack<Float> fStack = new Stack<Float>();
	static Stack<Integer> operatorStack = new Stack<Integer>();
	String input;

	public static void main(String[] args) {
		CalculatorFinal sample = new CalculatorFinal();

		sample.getInfo();
		System.out.println("your answer is " + sample.run(sample.input));

		/*
		 * getInfo(); split2Stack(); //System.out.println(fStack);
		 * //System.out.println(operatorStack); finalStackCalculate();
		 * System.out.print("your answer is " + fStack.pop());
		 */
	}

	public void getInfo() {
		Scanner getInfo = new Scanner(System.in);
		System.out.println("input String");
		input = getInfo.nextLine();
		getInfo.close();
	}

	public float run(String inputExpression) {
		input = inputExpression;
		split2Stack();
		finalStackCalculate();

		return fStack.pop();
	}

	// 쪼개서 스택에 각각 저장했다
	private void split2Stack() {
		Scanner scan = new Scanner(input);

		while (scan.hasNext()) {
			if (scan.hasNextFloat()) {
				float pushFloat = scan.nextFloat();
				fStack.push(pushFloat);
			} else {
				char operator = scan.next().charAt(0);
				int priorityNum = convertPriority(operator); // 우선순위 반환
				stopoverCalculate(priorityNum); // 우선순위 작은 연산자 들어오면
			}
		}
		System.out.println(fStack);
		System.out.println(operatorStack);
		scan.close();
	}

	private static void finalStackCalculate() {
		while (!operatorStack.isEmpty()) {
			if (operatorStack.peek() == 7) {
				operatorStack.pop();
			}
			float answer = calculate(operatorStack.pop(), fStack.pop(),
					fStack.pop());
			fStack.push(answer);
			// System.out.println(fStack);
			// System.out.println(operatorStack);
		}
	}

	private static void stopoverCalculate(int priorityNum) {
		while (true) {
			if (operatorStack.isEmpty()) {
				operatorStack.push(priorityNum);
				break;
			} else {
				if (priorityNum >= operatorStack.peek()) {
					operatorStack.push(priorityNum);
					break;
				} else {
					if (operatorStack.peek() == 6) {
						if (priorityNum == 0) {
							operatorStack.pop();
						} else {
							operatorStack.push(priorityNum);
						}
						break;
					} else {
						float middleProcess = calculate(operatorStack.pop(),
								fStack.pop(), fStack.pop());
						fStack.push(middleProcess);
					}
				} // else
			} // else
		} // while()
	} // stopoverCalculate()

	// /*
	// while (!operatorStack.isEmpty() && operatorStack.peek() != 6 /* ! (
	// operatorStack.isEmpty() || operatorStack.peek() == 6 ) */ ) {
	// if (priorityNum <= operatorStack.peek()) {
	// float middleProcess = sample.calculate(
	// operatorStack.pop(), fStack.pop(),
	// fStack.pop());
	// fStack.push(middleProcess);
	// } else
	// break;
	// }
	// while(true) {
	// if(operatorStack.isEmpty()) break;
	// if(operatorStack.peek() == 6) break;
	// if(priorityNum > operatorStack.peek()) break;
	//
	// float middleProcess = sample.calculate(operatorStack.pop(), fStack.pop(),
	// fStack.pop());
	// fStack.push(middleProcess);
	// }
	//
	// }
	// */

	public static int convertPriority(char operator) {
		int a = 0;
		switch (operator) {
		case '+':
			a = 1;
			break;
		case '-':
			a = 2;
			break;
		case '*':
			a = 3;
			break;
		case '/':
			a = 4;
			break;
		case '^':
			a = 5;
			break;
		case '(': // 괄호 열기 숫자 6
			a = 6;
			break;
		case ')': // 괄호 닫기 숫자 0
			a = 0;
			break;
		case '=':
			a = 7;
			break; // = 나오면 그냥 팝해버림.으로 처리해야할듯.
		}
		return a;
	}

	public static float calculate(int priority, float fStackUpper, float fStackBelow) {
		if (priority == 1) {
			return fStackBelow + fStackUpper;
		} else if (priority == 2) {
			return fStackBelow - fStackUpper;
		} else if (priority == 3) {
			return fStackBelow * fStackUpper;
		} else if (priority == 4) {
			return fStackBelow / fStackUpper;
		} else if (priority == 5) {
			float temp = fStackBelow;
			if(fStackUpper == 0){
				return 1;
			} else if(fStackUpper < 0){
				float newUpper= (fStackUpper * -1);
				for(float square = 0; square < newUpper -1; square++ ){
					temp *= fStackBelow;
				}
				temp = 1 / temp;
			}else {
			for (float square = 0; square < fStackUpper - 1; square++) {
				temp = temp * fStackBelow;
			}
			}
			return temp;
		} else if (priority == 6) {
			operatorStack.push(priority);
		}

		return 0f;
	}
}