package acorn;

public class Calculator {

	public int add(int a, int b) {
		return a + b;
	}

	public int min(int a, int b) {
		return a - b;
	}

	public int mul(int a, int b) {
		return a * b;
	}
	
	public int div(int a, int b) {
		return a / b;
	}
	
	  public int[] divisor(int a) {
	       int count = 0;
	       for (int i = 1; i <= a; i++) {
	           if (a % i == 0) {
	               count++;
	           }
	       }

	       int[] divisors = new int[count];
	       count = 0;
	       for (int i = 1; i <= a; i++) {
	           if (a % i == 0) {
	               divisors[count] = i;
	               count++;
	           }
	       }

	       return divisors;
	   }

	/*
	 * public static void main(String[] args) { Test test = new ExTest(); int result
	 * = test.add(5, 3); System.out.println(result); }
	 */
	
	public static void main(String[] args) {
		Calculator c = new Calculator();
		int result = c.add(5, 3);
		int result2 = c.min(5, 3);
		int result3 = c.mul(5, 3);
		int result4 = c.div(5, 3);
		int[] divisors = c.divisor(4);
	       for (int divisor : divisors) {
	           System.out.print(divisor);
	       }
		//System.out.println(result);
		//System.out.println(result2);
		//System.out.println(result3);
		//System.out.println(result4);
	}
}
