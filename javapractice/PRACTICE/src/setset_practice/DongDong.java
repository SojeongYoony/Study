package setset_practice;

import java.util.Scanner;

public class DongDong {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int H = sc.nextInt();
		int M = sc.nextInt();
	    M -= 45;
	    if (H == 0) 
	    {
	        if (M < 0)
	        {
	            M = M + 60;
	            H = 23;
	        }	     
	    }
	    if (M < 0)
	    {
	        M = M + 60;
	        H -= 1;
	    }
	    System.out.println(H + " " + M);

	}

}
