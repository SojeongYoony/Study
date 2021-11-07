package ex1_variable_practice;

import java.util.Scanner;

public class Cigies {

	public static void main(String[] args) {

		 Scanner sc = new Scanner(System.in);
		
		 String addr = "";
		 System.out.print("주소를 입력하세요 : ");
		addr = sc.nextLine();
		
		System.out.println("주소 : " + addr);
		
		sc.close();

	}

}
