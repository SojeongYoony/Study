package ex1_variable_practice;

public class Ex1_literal_practice {

	public static void main(String[] args) {
		// while 
		
		
			int bank = 1000000000;
			int payment = 1000000;
			int time = (bank / payment);
			
			while (bank >= payment) {
				System.out.println(payment + "로" + bank + "를 채우려면" + time + "이다.");
				bank -= payment;
				
				System.out.println(bank);
				System.out.println(payment);
				
			}
			
			
		}
	}

