package practice_10_10;

import java.util.Scanner;

public class ScoreInputOutput {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("학년을 입력하시오 >>");
		int grade = sc.nextInt();
		System.out.println("점수를 입력하시오 >>");
		int score = sc.nextInt();
		
		if (grade >= 4) {
			if (score >= 70) {
				System.out.println("합격");
			
			} else {
				System.out.println("불합격");
			}
		} else if(score >= 60) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
		
		System.out.println("학년은 " + grade + "이고, " + "점수는 " + score + " 이다.");
		
		sc.close();
	}

}
