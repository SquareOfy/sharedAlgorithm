import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] cards = new int[N];
		for(int i=0; i<N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		int sum =0;
		int resultSum = 0;
		int gapMin = 300000;
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				for(int k=j+1; k<N; k++) {
					sum = cards[i] + cards[j]+cards[k];
					if (sum<=M && M-sum < gapMin ) {
						gapMin = M-sum;
						resultSum = sum;
					}
				}
			}
		}
		System.out.println(resultSum);
	
		
	}
}
