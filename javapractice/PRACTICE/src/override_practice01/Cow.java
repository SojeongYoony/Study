package override_practice01;

public class Cow implements Animal {
	// Cow에 Animal 메소드 상속해줌
	// Cow에서 Animal 메소드(eat)사용 가능
	// implements : 추상적, 다중상속가능(여럿)

	@Override
	// JVM한테 슈퍼클래스(Animal)메소드 불러왔다고 알려줌
	public void eat() {
		// Animal의 메소드 eat : 소는 풀을 먹는다
		System.out.println("소는 풀을 먹는다.");
	}
	public void walk() {
		// Cow의 메소드 walk : 소는 걸을 수 있다.
		System.out.println("소는 걸을 수 있다.");
	}
}
