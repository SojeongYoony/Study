package ex1_variable_practice;

import javax.swing.JOptionPane;

public class Plus {

	public static void main(String[] args) {

		
		String strAge = JOptionPane.showInputDialog("몇 살이니?");
		int age = Integer.parseInt(strAge);
		
		JOptionPane.showMessageDialog(null, "넌 " + age + "살이구나~");
		
		
		String strBmonth = JOptionPane.showInputDialog("몇 월 생이니?");
		int bmonth = Integer.parseInt(strBmonth);
		JOptionPane.showMessageDialog(null, "넌 " + bmonth + "월 생이구나~");
		
		String strName = JOptionPane.showInputDialog("이름은 뭐야?");

	//String strAge = JOptionPane.showInputDialog("몇 살이니?");
	//int age = Integer.parseInt(strAge);
	
	//JOptionPane.showMessageDialog(null, "넌 " + age + "살이구나~");
	
	
	
	
	
	

	}

}
