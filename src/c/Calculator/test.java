package c.Calculator;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		for (int a = 1; a <= 9; a++){
			fibo(a);
		}
		System.out.println("fibo(9) = " + fibo(9));
		apple("apple");
	}
	
	static float fibo(int n){
		if ( n == 1){
			return 2;
		} else if (n == 2){
			return 3;
		} else {
			return fibo(n - 1) * fibo(n - 2);
		}
	}
	
	static void apple(String apple){
		ArrayList<Character> list = new ArrayList<Character>();
		for(int a = 0; a < apple.length(); a ++){
			char asc2= apple.charAt(a);
//			System.out.println(asc2);
			list.add(asc2);
		}
//		System.out.println(list);
		for(int a = 0; a < list.size(); a++){
			for (int b = a + 1; b < list.size(); b++){
				if (list.get(a) > list.get(b)){
					char temp = list.get(a);
					list.set(a, list.get(b));
					list.set(b, temp);
				}
			}
		}
		for(int index = 0; index <list.size(); index++){
			System.out.print((char) list.get(index));
		}
		
	}
}

