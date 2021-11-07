package override_practice01;

public class Zoo {

	private Animal[] animals;
		// Animal 배열 생성 
	private int idx;
		// 동물 수를 셀 것 이기 때문에 int형 사용, 변수명 : idx
	public Zoo() {
		animals = new Animal[3];
		// animals 배열크기는 3 ((0, 1, 2)idx) 3개만 저장 가능함 	
	}
	public void addAnimal(Animal animal) {
		// Animal의 수 추가할 것임.
		if (idx == animals.length) {
			// 만약 idx의 값과 animal배열의 길이가 같으면
			System.out.println("Full!");
			// Full!을 출력한다. 4개 넣으면 Full출력
			return;
		}
		animals[idx++] = animal;
			// animals에 animal이 들어오면 +1 함
	}
	public void animalsInfo() {
			// animal 정보
		for (int i = 0; i < idx; i++) {
			// int i = 0; 배열의 시작이 0이라서 0으로 초기화
			// i < idx; idx보다 작아야 하니까 idx미만까지((0, 1, 2)idx)
			// i++ --> animal 추가하고 +1 함
			animals[i].eat();
			// animals의 기능 eat 출력하고
			if (animals[i] instanceof Lion) {
				// Lion이 animals중 하나면 
				((Lion)animals[i]).run();
				// animals를 Lion으로 Casting하고 run기능 사용
			} else if(animals[i] instanceof Shark) {
				// 만약 Shark가 animals 중 하나면
				((Shark)animals[i]).swim();
				// Shark로 Casting하고 Shark의 메소드 swim사용
			} else if(animals[i] instanceof Cow) {
				// 만약 Cow가 animals 중 하나면
				((Cow)animals[i]).walk();
				// Cow로 Casting하고 Cow 메소드 walk 사용
			} else if(animals[i] instanceof Cat) {
				// Cat이 animals중 하나면
				((Cat)animals[i]).cute();
				// Cat으로 캐스팅하고 cute사용
			}
		}
	}
}
