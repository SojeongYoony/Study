package practice_10_10;

import java.util.Scanner;

public class Money {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		int[] currency = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1}; // 권종 및 동전
		int[] count = new int[10];
		System.out.println("금액을 입력하세요 >>> ");
		int inputmoney = scanner.nextInt();
		
		for (int i=0; i< currency.length; i++) {
			count[i] = inputmoney / currency[i];
			if(count[i]>0) {
				System.out.println(currency[i] + "원 짜리 : " + count[i] + "개");
				inputmoney = inputmoney % currency[i];
			}
		}
		scanner.close();
	}

}
