package practice_10_10;

import java.util.Scanner;

public class Input_Output {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("이름을 입력하세요 >>> ");
		String name = scanner.next();
		System.out.print("나이를 입력하세요 >>>");
		int age = scanner.nextInt();
		System.out.println("키를 입력하세요 >>>");
		double tall = scanner.nextDouble();
		System.out.println("성별을 입력하세요 F/M >>>");
		char gender = scanner.next().charAt(0);
		
		System.out.println("이름" + name+"\n" + "나이" + age+"\n" + "키" + tall+"\n" + "성별" + gender+"\n");
		scanner.close();
	}

}
