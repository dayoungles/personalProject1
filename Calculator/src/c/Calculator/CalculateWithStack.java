package c.Calculator;

import java.util.Stack;
import java.util.Scanner;

public class CalculateWithStack {
	static Stack<Float> fStack = new Stack<Float>();
	static Stack<Integer> operatorStack = new Stack<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalculateWithStack sample = new CalculateWithStack();
		// sample.calculate('*');
		String expression = "7 ^ 2 - 4 * 7 / 2 ^ 2 * 2";
		Scanner scan = new Scanner(expression);
		// String calculus;
		// while (true) {

		// System.out.println(calculus);
		split2Stack(sample, scan);
		finalStackCalculate(sample);
		System.out.print("your answer is " + fStack.pop());
		// }
	}
	
	public static void scannerTest(Scanner scan){
		scan.hasNext();
	}
	
	// 쪼개서 스택에 각각 저장했다
	private static void split2Stack(CalculateWithStack sample, Scanner scan) {
		// System.out.println("Input calculus(?;)");
		// String calculus = scan.nextLine();

		while (scan.hasNext()) {
			if (scan.hasNextFloat()) {
				float pushFloat = scan.nextFloat();
				// System.out.println(pushFloat);
				fStack.push(pushFloat);
			} else {
				char operator = scan.next().charAt(0);
				int priorityNum = sample.convertPriority(operator);// 우선순위 반환
				// System.out.println(priorityNum); //우선순위로 변환 확인했음
				stopoverCalculate(sample, priorityNum);// 우선순위 작은 연산자 들어오면 일단
														// 계산해서 넣어줌
			}
			
			System.out.println(fStack);
			System.out.println(operatorStack);
		}
	}

	private static void finalStackCalculate(CalculateWithStack sample) {
		while (!operatorStack.isEmpty()) {
			float answer = sample.calculate(operatorStack.pop(), fStack.pop(),
					fStack.pop());
			fStack.push(answer);
			System.out.println(fStack);
			System.out.println(operatorStack);
		}
	}

	private static void stopoverCalculate(CalculateWithStack sample, int priorityNum) { // 우선순위 비교해서 계산까지.종료조건!!!!이건 비교만 하지, 쌓여있을 때는 어떻게 할지?
		if (operatorStack.isEmpty()) {
			operatorStack.push(priorityNum);
		} else {
			while(true/*isEmpty*/){//스택 픽이랑 비교해서 크거나 같을 때까지만 돈다.
				if (priorityNum >= operatorStack.peek()) { //우선순위가 높으면 일단 operatorStack에 쌓는다. 
					operatorStack.push(priorityNum);
					
				} else {
					float middleProcess = sample.calculate(operatorStack.pop(), fStack.pop(), fStack.pop());
					fStack.push(middleProcess);
					operatorStack.push(priorityNum);
				}
			}
		}
	}

	public int convertPriority(char operator) {
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
		case '(': //괄호 열기 숫자 6
			a = 6;
			break;
		case ')': //괄호 닫기 숫자 0
			a = 0;
			break;
		}
		return a;
	}

	public float calculate(int priority, float fStackUpper, float fStackBelow) {
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
			for (float square = 0; square < fStackUpper - 1; square++) {
				temp = temp * fStackBelow;
				// System.out.println(fStackBelow);
			}
			return temp;
		}
		return 0f;
	}
	/*
	public void bracketCalc(){
		 그러면 priorityNum == 6이랑 7이 나왔을 때 예외상황을 설정해야.. 
		 * 6이 들어오면 이 메소드로 옮겨오고,
		 * 이 안에서 또 stopoverCalc를 이용해서 나온 값은 변수에 저장해 둔다...
		 * 그러다가, 7이 들어오면 변수에 저장한 값을 fStack에 푸쉬..
		 * 
		 * if (priorityNum == 6){//6이면 7이 들어올 때까지...while?
				float inBracketCal = sample.calculate(operatorStack.pop(), fStack.pop(), fStack.pop());
		}
		*/	
}

