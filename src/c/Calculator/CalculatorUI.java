package c.Calculator;
import javax.swing.*;

public class CalculatorUI {
	static final int WIDTH = 350;
	static final int HEIGHT = 500;
	
	private JFrame frame = new JFrame();
	
	public CalculatorUI() {
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main( String [] args){
		new CalculatorUI().show();
	}

	public void show() {
		frame.setVisible(true);
	}
	
	JFrame getFrame(){
		return frame;
	}
	
	void close(){
		frame.dispose();
	}
}
