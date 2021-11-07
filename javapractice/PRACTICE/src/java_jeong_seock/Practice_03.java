package java_jeong_seock;

import java.util.Scanner;

public class Practice_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("두 수를 쓰시오");

		int i;
		int k = sc.nextInt();
		int j = sc.nextInt();
		int temp;


		for (i = k; i <= j; i++){
			if ( i%2 == 0) 
				System.out.println(i);
				}
					temp = k; k = j ; j = temp;
						for (i = k; i <= temp; i++){
							if ( i%2 == 0){ 
 	
							System.out.println(i);
		}
		}

		}
			
}
