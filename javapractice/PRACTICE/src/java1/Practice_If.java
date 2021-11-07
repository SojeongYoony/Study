package java1;

import java.util.Scanner;

public class Practice_If {
	public static void main(String[]args) {
		
		//두 정수 A와 B가 주어졌을 때, A와 B를 비교하는 프로그램을 작성하시오.
		/*
		 * 첫째 줄에 다음 세 가지 중 하나를 출력한다.
			A가 B보다 큰 경우에는 '>'를 출력한다.
			A가 B보다 작은 경우에는 '<'를 출력한다.
			A와 B가 같은 경우에는 '=='를 출력한다.
			-10,000 ≤ A, B ≤ 10,000
		 */
	
			Scanner sc = new Scanner(System.in);
			System.out.print("정수 A의 값 : ");
			int A = sc.nextInt();

			if (A < -10000 || A > 10000) {
			System.out.println("다른 숫자를 입력해주세요");
			}
			
			System.out.print("정수 B의 값 : ");
			int B = sc.nextInt();

			if (B < -10000 || B > 10000) {
			System.out.println("다른 숫자를 입력해주세요");
			}else if(A > B) {
			System.out.println(">");
			}else if(B > A){
			System.out.println("<");
			}else if(A == B){
			System.out.println("==");
		
	}





sc.close();



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}//end main

}
