package c.Calculator;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;


public class Cal_Stack{
	
	Stack<Float> fStack = new Stack<Float>();
	Stack<Character> cStack = new Stack<Character>();
	String input;
	
	public static void main(String []args) throws IOException{
		//String text = "3+4";
		Cal_Stack reading = new Cal_Stack();
		String line = reading.getInfo();
		reading.parseString(line);
		
//		if (text.contains("+")) {//contains() 괄호안을 포함하고 있는지 확인하는 함수. 
//			String[] values = text.split("\\+");
//			System.out.println(values[0]);
//			System.out.println(values[1]);
//		}
	
	}
	
	boolean isReserved(String operator) {
		return operator.equals("+") || operator.equals("-")
				|| operator.equals("*") || operator.equals("/")
				|| operator.equals("e");
	}
	
	public String getInfo(){
		Scanner getInfo = new Scanner(System.in);
		System.out.println("input string");
		input = getInfo.nextLine();
		getInfo.close();
		//System.out.println(input);
		return input;
	}
	
	public void parseString(String input){
		Scanner scan = new Scanner(input);
		//System.out.println(input);
		//공백 중심으로 띄어쓰기 해서 파싱하면서 
		while (scan.hasNext()){
			if (scan.hasNextFloat()){
				fStack.push(scan.nextFloat());
			}else {
				char chr = scan.next().charAt(0);
				cStack.push(chr);
			}
		}
		
		System.out.println(fStack);
		System.out.println(cStack);
		//파싱된 element를 하나씩 받아서 플로트/캐릭터인지 확인 후, 
		//스택에 저장 
		
	}
/* isempty()  사용하면 스트링의 존재 여부를 확인 가능함
 * 지금부터 해야 할 일 :
 * 연산자 네개가 아닌 글자가 들어왔을 때 예외처리하는 법.??
 * 1. 연산자 우선순위 설정(계산 어떻게 해낼지 생각할 =곱하기 나누기가 나왔을 때는 와일문을 멈춘다.
 * 2. 연산자와 피연산자 팝해서 계산한 후 다시 넣는 
 */
}
