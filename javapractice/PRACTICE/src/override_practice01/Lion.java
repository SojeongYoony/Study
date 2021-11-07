package override_practice01;

public class Lion implements Animal{
	// Animal의 메소드 Lion에 상속
	// implements : 추상적, 다중상속
	@Override
	// 슈퍼클래스 Animal의 메소드 불러왔다고 알려줌
	public void eat() {
		// Animal클래스의 메소드 eat : 사자는 고기를 먹는다. (이건 부모꺼)
		System.out.println("사자는 고기를 먹는다.");
	}
	public void run() {
		// Lion클래스의 메소드 run : 사자는 달릴 수 있다. (이건 자식꺼)
		System.out.println("사자는 달릴 수 있다.");
	}
}
