package override_practice01;

public class Cat implements Animal{  
	// Animal 클래스를 Cat 클래스에 상속 -> Animal 기능 사용 가능
	@Override
	// (슈퍼클래스)Animal의 기능을 불러왔다는 것을 알려주기위해 Override 함.
	public void eat() {
		System.out.println("고양이는 떡볶이를 먹는다.");
		// eat 메소드 출력 -> 고양이는 떡볶이를 먹는다.
	}
	public void cute() {
		// Cat 클래스의 메소드 -> cute : 고양이는 귀엽고 애교쟁이다.
		System.out.println("고양이는 귀엽고 애교쟁이다.");
	}

}
