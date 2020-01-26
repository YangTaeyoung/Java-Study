public class Company {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int WORKER_NUM = 5; // worker들의 수. 변수의 값이 수정되지 않도록 바꿀것.
		Worker [] myWorker = new Worker[WORKER_NUM]; // worker들의 정보를 담을 참조형 변수.(객체배열은 아직 배우지 않았기 때문에 선언부를 미리 추가해두었습니다.)
		
		myWorker[0] = new FullTimeJob("김구라", 72, 4500000);
		myWorker[1] = new PartTimeJob("박월세", 254, 2000000, 55);
		myWorker[2] = new PartTimeJob("이전세", 132, 1500000, 48);
		myWorker[3] = new FullTimeJob("최증금", 332, 3000000);
		myWorker[4] = new FullTimeJob("서동산", 552, 2300000);
		
	
		
		for(int i = 0;i<WORKER_NUM; i++)// 출력부
		{
			myWorker[i].printInfo();
		}
	}
}
