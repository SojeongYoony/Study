package practice_10_10;

import java.util.Scanner;

public class java_1011_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int temp = b;
		
		while(temp != 0) {
			System.out.println(a * (temp%10));
			temp /=10;
		}
		System.out.println(a*b);
		
		
		sc.close();
	}

}
