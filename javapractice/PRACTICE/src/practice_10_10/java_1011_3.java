package practice_10_10;

import java.util.Scanner;

public class java_1011_3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		if (A >= -10000 || A <= 10000 && B >= -10000 || B <= 10000) {
			if (A>B) {
				System.out.println('>');				
			} else if (A <B) {
				System.out.println('<');
				
			} else if (A==B) {
				System.out.println("==");
				
			}
		
		
		}sc.close();
	}

}

