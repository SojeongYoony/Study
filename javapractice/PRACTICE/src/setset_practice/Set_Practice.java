package setset_practice;

import java.util.HashSet;
import java.util.Set;

public class Set_Practice {
	
	public static void method1() {
		
	
	Set<String> subjects = new HashSet<String>();
	
	subjects.add("자바");
	subjects.add("자바");
	subjects.add("자바");
	subjects.add("데이터베이스");
	
	
	System.out.println(subjects.size());

	}

	public static void main(String[] args) {
		method1();
	}
	
}
