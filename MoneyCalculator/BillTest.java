package Self_Task;

public class BillTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 문제 돈의 총액을 int 변수에 받고 그 필요에 따라 50000원짜리, 10000원짜리, 5000원 짜리 등 화폐가 각각 몇개가 필요한지 계산하라.
		// 돈의 금액을 바꿔도 계산이 가능하여야 함.
		
		//방안 .1: 각각 계산하는 변수를 만들기
		int inputCoin = 6912830;
		int bill50000 = inputCoin/50000;
		int bill10000 = inputCoin%50000/10000;
		int bill5000 = inputCoin%50000%10000/5000;
		int bill1000 = inputCoin%50000%10000%5000/1000;
		int coin500 = inputCoin%50000%10000%5000%1000/500;
		int coin100 = inputCoin%50000%10000%5000%1000%500/100;
		int coin50 =  inputCoin%50000%10000%5000%1000%500%100/50;
		int coin10 = inputCoin%50000%10000%5000%1000%500%100%50/10;
		System.out.println("50000원 지폐: "+bill50000+" 10000원 지폐: " + bill10000 +" 5000원 지폐: "+ bill5000 +" 1000원 지폐: "
		+ bill1000 +" 500원 동전: " + coin500 +" 100원 지폐: "+ coin100 + " 50원 동전: " + coin50 + " 10원 동전: " + coin10);
		System.out.println();
		
		//방안 2: 배열 이용
		int[] billType = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		int result = inputCoin;
		for(int i = 0; i < billType.length; i++)
		{
			if (billType[i] >= 1000)
				System.out.print(billType[i]+"원 지폐: " + result/billType[i] + " ");
			else
				System.out.print(billType[i]+"원 동전: " + result/billType[i] + " ");
			result = result%billType[i];
		}
	}

}
