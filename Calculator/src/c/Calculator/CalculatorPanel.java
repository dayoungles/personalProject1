package c.Calculator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorPanel extends JPanel {
	
	//이걸 스태틱에다가 다 써야만 할까?- 하다가 지금 망한 듯 화요일 오후  3:37
	private static JButton n1, n2, n3, n4, n5, n6, n7, n8, n9, n0, opPlus,
	opMinus, opMultiple, opDivide, refreshC, answer, point, bracket1, bracket2, square;
	static String text = null;
	static StringBuilder str = new StringBuilder();
	
	public CalculatorPanel(){
//		ButtonSelection bt = new ButtonSelection();
//		n1.addActionListener(bt);
	}
	
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
		
		
		addButton(createButtonLayout(buttonPanel));
		//액션 시작돼야 할 부분......
		appendButtonClick("1");
		appendButtonClick("2");
		
		JTextField showField = new JTextField(text, 20);
		showField.setEditable(false);//수정 불가
		showField.setHorizontalAlignment(0x4);//우측 정렬 
		fieldPanel.add(showField);
		
		
		mainPanel.add(fieldPanel);
		mainPanel.add(buttonPanel);
		frame.getContentPane().add(mainPanel);
		frame.setVisible(true);
		
		
		/*
		 * 필드 세로 사이즈 키우기
		 */
	}

	private static JPanel createButtonLayout(JPanel buttonPanel) {
		
		buttonPanel.setLayout(new GridLayout(4, 5));
		
		n1 = createButton("1");
		n2 = createButton("2");
		n3 = createButton("3");
		n4 = createButton("4");
		n5 = createButton("5");
		n6 = createButton("6");
		n7 = createButton("7");
		n8 = createButton("8");
		n9 = createButton("9");
		n0 = createButton("0");
		opPlus = createButton("+");
		opMinus = createButton("-");
		opMultiple = createButton("*");
		opDivide = createButton("/");
		refreshC = createButton("C");
		answer = createButton("=");
		point = createButton(".");
		bracket1 = createButton("(");
		bracket2 = createButton(")");
		square = createButton("^");
		return buttonPanel;
	}
	
	private static JPanel addButton(JPanel buttonPanel) {
		
		buttonPanel.add(n7);
		buttonPanel.add(n8);
		buttonPanel.add(n9);
		buttonPanel.add(opDivide);
		buttonPanel.add(bracket1);

		buttonPanel.add(n4);
		buttonPanel.add(n5);
		buttonPanel.add(n6);
		buttonPanel.add(opMultiple);
		buttonPanel.add(bracket2);

		buttonPanel.add(n1);
		buttonPanel.add(n2);
		buttonPanel.add(n3);
		buttonPanel.add(opMinus);
		buttonPanel.add(square);

		buttonPanel.add(point);
		buttonPanel.add(n0);
		buttonPanel.add(refreshC);
		buttonPanel.add(opPlus);
		buttonPanel.add(answer);
		
		return buttonPanel;
	}

	
//	private static void actionRegister(){
//		ButtonSelection num1 = new ButtonSelection();
//		n1.addActionListener(num1);
//	}

	private static JButton createButton(String addButtonText) {
		JButton addButton = new JButton(addButtonText);
		addButton.setName(addButtonText);
		return addButton;
	}
	
	static public void appendButtonClick(String number){
		str.append(number + " ");//결국 return getName 필요할 듯..
		text = str.toString();
	}
	
	void checkEqual (){
		if(text.endsWith("=")){
			//CalculatorFinal.main();
			//CalculatorFinal(); //계산기 클래스 실행은 어떻게 시키냐?;;;
		}
	}
	
	/**
	 * 액션리스너를 정의한다.
	 * @author dayoungle
	 *
	 */
	private class ButtonSelection implements ActionListener{
		ButtonSelection(){
			
		}
		
		public void actionPerformed(ActionEvent event){
			String temp = getName();
			appendButtonClick(temp);
		}
	}
}
