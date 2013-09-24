package c.Calculator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import c.Calculator.CalculatorFinal;

public class CalculatorPanel extends JPanel {
	//연산자 두개가 연달아 입력될 때 막도록...괄호 제외.
	//이걸 스태틱에다가 다 써야만 할까?- 하다가 지금 망한 듯 화요일 오후  3:37
	private static JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnPoint,
	btnPlus,btnMinus, btnMultiply, btnDivide, btnBracket1, btnBracket2, btnSquare,
	btnRefreshC, btnEqual ;
	
	static String text = null;
	static JTextField showField = new JTextField(text, 20);
	StringBuilder str = new StringBuilder();

	CalculatorFinal calculator = new CalculatorFinal();
	
	public static void main(String[] args) {
		
		CalculatorPanel cPanel = new CalculatorPanel();

		JFrame frame = new JFrame();
		JPanel mainPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JPanel fieldPanel = new JPanel();
		
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);// 프레임 크기 고정
//		showField.setLineWrap(true);
//		showField.set//20130923 필드 사이즈, 필드 자동 줄바꿈 설정 해야 
//		
		createButtonLayout(buttonPanel);
		
		ButtonSelection num1 = cPanel.new ButtonSelection('1');
		ButtonSelection num2 = cPanel.new ButtonSelection('2');
		ButtonSelection num3 = cPanel.new ButtonSelection('3');
		ButtonSelection num4 = cPanel.new ButtonSelection('4');
		ButtonSelection num5 = cPanel.new ButtonSelection('5');
		ButtonSelection num6 = cPanel.new ButtonSelection('6');
		ButtonSelection num7 = cPanel.new ButtonSelection('7');
		ButtonSelection num8 = cPanel.new ButtonSelection('8');
		ButtonSelection num9 = cPanel.new ButtonSelection('9');
		ButtonSelection num0 = cPanel.new ButtonSelection('0');
		ButtonSelection opPlus = cPanel.new ButtonSelection('+');
		ButtonSelection opMinus = cPanel.new ButtonSelection('-');
		ButtonSelection opDivide = cPanel.new ButtonSelection('/');
		ButtonSelection opMultiply= cPanel.new ButtonSelection('*');
		ButtonSelection opRefreshC = cPanel.new ButtonSelection('C');
		ButtonSelection opEqual = cPanel.new ButtonSelection('=');
		ButtonSelection opDot = cPanel.new ButtonSelection('.');
		ButtonSelection opBracket1 = cPanel.new ButtonSelection('(');
		ButtonSelection opBracket2 = cPanel.new ButtonSelection(')');
		ButtonSelection opSquare = cPanel.new ButtonSelection('^');
		
		btn1.addActionListener(num1);
		btn2.addActionListener(num2);
		btn3.addActionListener(num3);
		btn4.addActionListener(num4);
		btn5.addActionListener(num5);
		btn6.addActionListener(num6);
		btn7.addActionListener(num7);
		btn8.addActionListener(num8);
		btn9.addActionListener(num9);
		btn0.addActionListener(num0);
		btnPlus.addActionListener(opPlus);
		btnMinus.addActionListener(opMinus);
		btnMultiply.addActionListener(opMultiply);
		btnDivide.addActionListener(opDivide);
		btnEqual.addActionListener(opEqual);
		btnPoint.addActionListener(opDot);
		btnBracket1.addActionListener(opBracket1);
		btnBracket2.addActionListener(opBracket2);
		btnSquare.addActionListener(opSquare);
		btnRefreshC.addActionListener(opRefreshC);
		
		showField.setEditable(false);//수정 불가
		showField.setHorizontalAlignment(0x4);//우측 정렬 
		fieldPanel.add(showField);
		
		mainPanel.add(fieldPanel);
		mainPanel.add(buttonPanel);
		frame.getContentPane().add(mainPanel);
		frame.setVisible(true);
	}

	private static JPanel createButtonLayout(JPanel buttonPanel) {
		
		buttonPanel.setLayout(new GridLayout(4, 5));
		
		btn1 = createButton("1");
		btn2 = createButton("2");
		btn3 = createButton("3");
		btn4 = createButton("4");
		btn5 = createButton("5");
		btn6 = createButton("6");
		btn7 = createButton("7");
		btn8 = createButton("8");
		btn9 = createButton("9");
		btn0 = createButton("0");
		btnPlus = createButton("+");
		btnMinus = createButton("-");
		btnMultiply = createButton("*");
		btnDivide = createButton("/");
		btnRefreshC = createButton("C");
		btnEqual = createButton("=");
		btnPoint = createButton(".");
		btnBracket1 = createButton("(");
		btnBracket2 = createButton(")");
		btnSquare = createButton("^");

		buttonPanel.add(btn7);
		buttonPanel.add(btn8);
		buttonPanel.add(btn9);
		buttonPanel.add(btnDivide);
		buttonPanel.add(btnBracket1);
		
		buttonPanel.add(btn4);
		buttonPanel.add(btn5);
		buttonPanel.add(btn6);
		buttonPanel.add(btnMultiply);
		buttonPanel.add(btnBracket2);
		
		buttonPanel.add(btn1);
		buttonPanel.add(btn2);
		buttonPanel.add(btn3);
		buttonPanel.add(btnMinus);
		buttonPanel.add(btnSquare);
		
		buttonPanel.add(btnPoint);
		buttonPanel.add(btn0);
		buttonPanel.add(btnRefreshC);
		buttonPanel.add(btnPlus);
		buttonPanel.add(btnEqual);
		return buttonPanel;
	}
	
	
/**
 * 버튼 숫자 를 이름으로 세팅하고 버튼 생성해서 
 * @param addButtonText
 * @return 버튼을 리턴 
 */
	private static JButton createButton(String addButtonText) {
		JButton addButton = new JButton(addButtonText);
		addButton.setName(addButtonText);//겟네임 없으면 필요없는 라인 
		return addButton;
	}
	
	public void appendCharToText(char inputChar){//2013.9.17 22:13 
		checkEndOfStrThenAppend(inputChar);
		//str.append(inputChar);
		text = str.toString();
		checkEqual();
	}
	
	/**
	 * 수식의 마지막을 "=" 으로 확인함.
	 */
	public void checkEqual (){
		if(text.endsWith("= ")){
			float answer = calculator.run(text);
			text = "" + answer;
			str.delete(0, str.length());
		} else if(text.endsWith("C ")){
			text = null;
			str.delete(0, str.length());
		}
	}
	void checkEndOfStrThenAppend(char inputChar){
		if(checkOperand(inputChar)){
			str.append(" " + inputChar + " ");
		} else if(inputChar == '-'){
			if(str.toString().endsWith("( ")|| str.toString().endsWith("* ") || str.toString().endsWith("^ ")
					|| str.length() == 0){//왜 스트링 널값이 안 걸릴까? 
				str.append(inputChar);
			} else {
				str.append(" " + inputChar + " ");
			}
		}
		else {
			str.append(inputChar);
		}
	}
	
	boolean checkOperand(int inputChar){
		if(inputChar == '+' /*|| inputChar == '-'*/ || inputChar == '*' || inputChar == '/' || inputChar == '^' || inputChar == '(' || 
				inputChar == ')' || inputChar == 'C' || inputChar == '=' ){
			return true;
		}
		return false;
	}
	
	class ButtonSelection implements ActionListener{
		private char buttonName;
		ButtonSelection(char inButtonName){
			buttonName = inButtonName;
		}
		
		public void actionPerformed(ActionEvent event){
			appendCharToText(buttonName);
			showField.setText(text);
		}
	}
}

