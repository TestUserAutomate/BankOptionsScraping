package test.BankNifty;

public class A {

	public static void main(String args[]){
		
		 double x = 123456789.02;
		    System.out.println("x = " + x);
		    double hi = x, n = 0;
		    while (hi > 9) {
		        hi /= 10;
		        ++n;
		    }
		    for (int i = 0; i < n; i++) hi *= 10;
		    x -= hi;
		    System.out.println("x with high digit removed = " + x);
	}
}
