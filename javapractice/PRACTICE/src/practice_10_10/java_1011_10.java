package practice_10_10;

import java.util.Scanner;

public class java_1011_10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 틀림 수정 해야함 
		int H = sc.nextInt();
		int M = sc.nextInt();
		M -=45;		

		if(M < 0) {
			H-=1;
			M+=60;
			if(H==0) {
				H=23;	
			}else if(H<0) {
				H+=24;
			}
		}
		System.out.println(H + " " + M);
		sc.close();
	}
	
}
