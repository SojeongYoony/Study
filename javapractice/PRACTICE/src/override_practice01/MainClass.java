package override_practice01;

public class MainClass {

	public static void main (String[] args) {
		
		Zoo zoo = new Zoo();
		// Zoo 클래스의 객체 생성
		// 참조 변수명 : zoo
		// new Zoo의 값을 zoo에 저장
		
		
		zoo.addAnimal(new Lion());
		zoo.addAnimal(new Shark());
		zoo.addAnimal(new Cow());
		zoo.addAnimal(new Cat());
		zoo.animalsInfo();
		
		// Lion 기능 고기먹기,달리기 출력
		// Shark 기능 물고기먹기, 헤엄치기 출력
		// Cow 기능 풀먹기, 걷기 출력
		// 배열 크기 3 --> 세마리만 출력, Full!문구 나옴
		// Cat은 자리없어서 못들어감 --> Full
		
	}
	
}
