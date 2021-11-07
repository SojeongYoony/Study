package practice_10_10;

import java.util.Scanner;

public class Coffee {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("메뉴를 입력하세요 >>");
		String command = sc.next();
		
		
		switch (command) {
		case "카푸치노": case "에스프레소": case "카페라떼" : 
			System.out.println("3500원 입니다.");
			break;

		case "아메리카노":
			System.out.println("2000원 입니다.");
			break;
		}
		sc.close();
	}

}
