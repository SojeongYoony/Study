package practice;

import java.util.Scanner;

public class ex_01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String name;
		int age;
		double length;
		char gender;
		
		System.out.println("넌 이름이 뭐니");
		sc.next();
		System.out.println("몇 살이니");
		sc.nextInt();
		System.out.println("키는 몇이니");
		sc.nextDouble();
		System.out.println("성별은? F/M");
		sc.next();
		
		System.out.println("너의 이름은" + sc.next() + "이고 나이는 " + sc.nextInt() + "살 이구나");
		
	}

}
