package c.Calculator;

import java.util.Scanner;
import java.util.Stack;

public class Calculator1 {
	float firstOperand, sndOperand;
	String operator;
	Stack<Float> stk; // import Stack �ϸ� ��..���õ� �׳� �� ������� �־�..���...���......

	public static void main(String[] args) {

		Calculator1 sample = new Calculator1();// ��ü ����
		sample.getInput();//
		// sample.getAnswer();

	}

	boolean isReserved(String operator) {
		return operator.equals("+") || operator.equals("-")
				|| operator.equals("*") || operator.equals("/")
				|| operator.equals("e");
	}

	public void getInput() {
		Scanner input = new Scanner(System.in);// �Ķ���ͷ� num�� ������ hasNextInt���� ����
												// �޾Ƽ� �Ľ��ϰ� �ȴ�.->num�� �޴�

		float answer = 0;

		while (true /* input.hasNextFloat() */) { // int parsing :hasNextInt()
			// operator ����
			System.out.println("input Operator");

			while (true) {
				operator = input.next();
				if (isReserved(operator)) {
					break;
				} else {
					System.out.println("Input proper operator again");
				}
			}
			// e�� �Է��� ��� ���α׷� ���� ���
			if (operator.equals("e")) {
				System.out.println("Program ended");
				break;
			}

			// ���� �ΰ� �Է¹ޱ�

			/*
			 * ���� ����ó�� ���� �Ф� while(true){
			 * System.out.println("input two number"); while (true){ if
			 * (!input.hasNextFloat()) {
			 * System.out.println("Input proper Float type"); }else{
			 * firstOperand = input.nextFloat(); sndOperand = input.nextFloat();
			 * break; } }
			 */
			// firstOperand = input.nextFloat();
			
			//���� �ΰ� �Է� ���� 
			System.out.println("input two number");
			firstOperand = input.nextFloat();
			sndOperand = input.nextFloat();

			if (!isReserved(operator)) {
				System.out.println("Wrong operator. Input again: ");
				continue;// while ������ ���ư��� �ϰ� ������ continue�� �̿��Ѵ�.
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
