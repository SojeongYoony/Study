package practice;

import java.util.Scanner;

public class ex_01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String name;
		int age;
		double length;
		char gender;
		
		System.out.println("�� �̸��� ����");
		sc.next();
		System.out.println("�� ���̴�");
		sc.nextInt();
		System.out.println("Ű�� ���̴�");
		sc.nextDouble();
		System.out.println("������? F/M");
		sc.next();
		
		System.out.println("���� �̸���" + sc.next() + "�̰� ���̴� " + sc.nextInt() + "�� �̱���");
		
	}

}
