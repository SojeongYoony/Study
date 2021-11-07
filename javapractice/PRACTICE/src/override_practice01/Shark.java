package override_practice01;

public class Shark implements Animal {
	// Shark 클래스에 Animal클래스 메소드를 상속해줌
	// Shark 클래스에서 Animal 클래스 메소드 사용 가능
	// implements : 다중상속 가능하고 추상적임(형태없음)

	@Override
	// Animal의 기능을 불러왔다는 것을 알려주기위해 Override 함.
	public void eat() {
		// Animal 클래스의 메소드 eat : 상어는 물고기를 먹는다.
		System.out.println("상어는 물고기를 먹는다.");
	}
	public void swim() {
		// Shark 클래스의 메소드 swim : 상어는 헤엄을 칠 수 있다.
		System.out.println("상어는 헤엄을 칠 수 있다.");
	}
}
