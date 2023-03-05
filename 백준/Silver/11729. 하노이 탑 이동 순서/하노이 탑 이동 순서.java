import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;



public class Main {
	static int[] numbers = new int[21];
	static StringBuilder sb = new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		sb.append(hanoiNum(N)).append("\n");
		hanoiMove(N,1,3);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	
	static int hanoiNum(int n) {
		if(n==1)	{
			if(numbers[n] ==0 ) {
				numbers[n]=1; 
			}
			return 1;
		}
		if(numbers[n]==0) {
			numbers[n] = hanoiNum(n-1)*2 +1;
			return numbers[n];
		}
		return numbers[n];

	}
	//n개의 원판을 a에서 b로 이동시켜 보자.
	static void hanoiMove(int n, int a, int b) {

		int start = a;
		int destination = b;
		int temp =0;
		if((start==1 && destination ==3)||(start==3 && destination ==1)) temp =2;
		if((start==2 && destination ==3)||(start==3 && destination ==2)) temp =1;
		if((start==1 && destination ==2)||(start==2 && destination ==1)) temp =3;
		
		if(n==1) {
			sb.append(start).append(" ").append(destination).append("\n");
			return;
		}
		
		//원판의 개수가 짝수 일 땐 맨 처음 옮기는 원판을 목적지가 아닌 다른 칸으로 옮겨야 함.
		if(n>1) {
			hanoiMove(n-1, start, temp);
			sb.append(start).append(" ").append(destination).append("\n");
			hanoiMove(n-1, temp, destination);
			return;
		}
	}

}