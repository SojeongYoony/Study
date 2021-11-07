package practice_10_10;

import java.util.Scanner;

public class Java_1011_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("세 숫자 입력 받기 >>> ");
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		if ((A >= 2 || A <= 10000) && (B >= 2 || B <=10000) && (C >= 2 || C <=10000)) {
			
		System.out.println((A + B)% C);		
		System.out.println(((A%C)+(B%C))%C);		
		System.out.println((A*B)% C);		
		System.out.println(((A%C)*(B%C))%C);		
		}
		sc.close();
	}
}
