package java1;

public class Hakjum {

	public static void main(String[] args) {
		char hakjum =  ' ';
		int jumsu = 80;
		
		hakjum = (jumsu >= 90)? 'A' : ((jumsu >=80)? 'B' : 'C');

		
		System.out.println("당신의 점수는" + jumsu + "이고 " + hakjum + "등급이다." );
		
		int x = 9;
		if (x > 10 && x < 20) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
	
	
		char ch='Z';
	      if ((int)ch >= 65 && ch <= 128) {
	         System.out.println(true);
	      }else {
	         System.out.println(false);
	      }


	
	}
	

}
