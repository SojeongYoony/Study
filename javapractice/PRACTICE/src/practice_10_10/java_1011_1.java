package practice_10_10;

import java.util.Scanner;

public class java_1011_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("두 자연 수 A와 B를 입력하시오");
		int A = sc.nextInt();
		int B = sc.nextInt();
		if ((A < 0 || A > 10001) && (B <0 || B > 10001)) {
			System.out.println("잘못 된 숫자 입니다.");
		} else {
			System.out.println(A+B);
			System.out.println(A-B);
			System.out.println(A*B);
			System.out.println(A/B);
			System.out.println(A%B);
		}
		sc.close();

	}

}
