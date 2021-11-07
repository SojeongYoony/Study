package practice_10_10;

import java.util.Scanner;

public class Practice01 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int sum = 0;
		System.out.println("숫자를 입력하세요 >>>");
		int num = scanner.nextInt();

			for (int i =0; i <= num; i++) {
				if(i%2==0) 
					sum += i;					
				}
			System.out.println("1에서부터" + num + " 까지 짝수의 합 : " + sum);
			scanner.close();		
	}
	
	}


