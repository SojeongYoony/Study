package java1;

import java.util.Scanner;
public class Main{
	
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int a, b;
		System.out.print("더할숫자 하나");
		a = sc.nextInt();

		System.out.print("더할숫자 둘");
		b = sc.nextInt();

		System.out.println(a + " + " + b + " = " + (a+b));
		
		sc.close();
		
	}
}
