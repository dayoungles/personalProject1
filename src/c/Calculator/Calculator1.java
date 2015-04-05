package c.Calculator;

import java.util.Scanner;
import java.util.Stack;

public class Calculator1 {
	float firstOperand, sndOperand;
	String operator;
	Stack<Float> stk; // import Stack 하면 됨..스택도 그냥 다 만들어져 있어..우와...우왕......

	public static void main(String[] args) {

		Calculator1 sample = new Calculator1();// 객체 생성
		sample.getInput();//
		// sample.getAnswer();

	}

	boolean isReserved(String operator) {
		return operator.equals("+") || operator.equals("-")
				|| operator.equals("*") || operator.equals("/")
				|| operator.equals("e");
	}

	public void getInput() {
		Scanner input = new Scanner(System.in);// 파라미터로 num을 넣으면 hasNextInt에서 넘을
												// 받아서 파싱하게 된다.->num을 받는

		float answer = 0;

		while (true /* input.hasNextFloat() */) { // int parsing :hasNextInt()
			// operator 읽음
			System.out.println("input Operator");

			while (true) {
				operator = input.next();
				if (isReserved(operator)) {
					break;
				} else {
					System.out.println("Input proper operator again");
				}
			}
			// e를 입력할 경우 프로그램 종료 출력
			if (operator.equals("e")) {
				System.out.println("Program ended");
				break;
			}

			// 숫자 두개 입력받기

			/*
			 * 숫자 예외처리 실패 ㅠㅠ while(true){
			 * System.out.println("input two number"); while (true){ if
			 * (!input.hasNextFloat()) {
			 * System.out.println("Input proper Float type"); }else{
			 * firstOperand = input.nextFloat(); sndOperand = input.nextFloat();
			 * break; } }
			 */
			// firstOperand = input.nextFloat();
			
			//숫자 두개 입력 받음 
			System.out.println("input two number");
			firstOperand = input.nextFloat();
			sndOperand = input.nextFloat();

			if (!isReserved(operator)) {
				System.out.println("Wrong operator. Input again: ");
				continue;// while 앞으로 돌아가게 하고 싶으면 continue를 이용한다.
			} else if (operator.equals("e")) {
				System.out.println("Program end");
				break;
			}

			answer = calculate(operator, firstOperand, sndOperand);
			System.out.println(firstOperand + operator + sndOperand + " = "
					+ answer);
		}
	}

	float calculate(String operator, float firstOperand, float secondOperand) {
		float answer = 0f;
		if (operator.equals("+")) {
			answer = firstOperand + sndOperand;
		} else if (operator.equals("-")) {
			answer = firstOperand - sndOperand;
		} else if (operator.equals("*")) {
			answer = firstOperand * sndOperand;
		} else if (operator.equals("/")) {
			if (sndOperand == 0) {
				System.out.println("second operand can not be the ZERO");
				return 0f;
			}
			answer = firstOperand / sndOperand;

		}
		return answer;
	}

}
