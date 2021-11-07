package java_jeong_seock;

import java.util.Scanner;

public class Practice_4_6 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요");
		
		int year = sc.nextInt();
		System.out.println("입력한 숫자는 " + year + "입니다.");
	      if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0 ) {
	         System.out.println("결과는 " + true + "입니다.");
	      }else {
	         System.out.println("결과는 " + false + "입니다.");
	      }

	      
	}

}
