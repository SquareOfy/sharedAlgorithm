import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int L = Integer.parseInt(br.readLine());
		int[] cakes = new int[L+1];
		int N = Integer.parseInt(br.readLine());

		int maxOrd = 0;
		int maxOrdN = 0;
	
		for(int n=1; n<=N; n++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(b-a+1 > maxOrd) {
				maxOrd = b-a+1;
				maxOrdN = n;
			}
			for(int i=a; i<=b; i++) {
				if(cakes[i]==0) {
				cakes[i] =n;
			}		
		}

		}
		int[] cnt = new int[N+1]; ;//케이크 배열에 표기된 n을 index로 해서 각 번호의 사람이 몇개의 케이크를 받을지 셀 카운트배열
		for(int i=0; i<L; i++) {
			if(cakes[i]!=0) {
				cnt[cakes[i]]++;
			}
		}
		int max = 0;
		int maxN = 0;
		for(int i=1; i<=N; i++) {
			if (cnt[i] > max) {
				max = cnt[i];
				maxN = i;
			}
		}
		
		System.out.println(maxOrdN);
		System.out.println(maxN);
	}

}
