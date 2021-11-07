package practice_10_12;

import java.util.Scanner;

public class For_01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=1; i<=9; i++) {
			System.out.println(N + " * " + i +" = "+(i*N));
		}
		sc.close();
	}

}
