import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] numbers;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int [] num = new int[N];
		result = new int[M];

		st = new StringTokenizer(br.readLine());
 		for(int n=0; n<N; n++) {
			num[n] = Integer.parseInt(st.nextToken());
		}
 		
 	
 		int max = Arrays.stream(num).max().getAsInt();
 		
 		numbers = new int[max+1];
 		//카운팅 배열
 		for(int i=0; i<N; i++) {
 			numbers[num[i]]++;
 		}
 		
 		
 		combination(0);
 		
 		System.out.println(sb.toString());

	
 		
	}
	
	static void combination(int cnt) {
		if(cnt ==M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<numbers.length; i++) {
			if(numbers[i]!=0) {
				result[cnt] = i;
				combination(cnt+1);

			}
			
		}
	}
	

}
