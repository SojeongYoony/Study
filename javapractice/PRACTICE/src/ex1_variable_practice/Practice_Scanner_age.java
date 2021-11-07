package ex1_variable_practice;

import java.util.Scanner;

public class Practice_Scanner_age {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 키보드를 통해서 데이터를 입력하는 스케너
		String age = "";
		System.out.print("나이를 입력하세요 : ");
		age = sc.nextLine();
		System.out.println("나이 : " + age);
		
		
		Scanner na = new Scanner(System.in);
		String name = "";
		System.out.print("이름을 입력하세요 : ");
		name = na.nextLine();
		System.out.println("이름 : " + name);
		
		Scanner birth = new Scanner(System.in);
		String birthday = "";
		System.out.print("생일을 입력하세요 : ");
		birthday = birth.nextLine();
		System.out.println("생일 : " + birthday);
		
		
		sc.close();
		na.close();
		
		
		
		
	}

}
