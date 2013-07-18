package c.Calculator;

import junit.framework.TestCase;

public class CalculateWithStackTest extends TestCase {
	public void testConvertPriority() throws Exception {
		CalculateWithStack cal = new CalculateWithStack();
		assertEquals(1, cal.convertPriority('+'));
		assertEquals(2, cal.convertPriority('-'));
		assertEquals(3, cal.convertPriority('*'));
		assertEquals(4, cal.convertPriority('/'));
	}
	public void testComparePriority() throws Exception {
		CalculateWithStack compareP = new CalculateWithStack();
		
	}
	public void testCalculate() throws Exception {
		CalculateWithStack check = new CalculateWithStack();
		assertEquals(8, check.calculate(5, 3, 2)); ;
	}
}
