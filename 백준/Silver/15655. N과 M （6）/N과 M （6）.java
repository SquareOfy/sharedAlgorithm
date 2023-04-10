import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] numbers;
	static boolean[] visited;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		result = new int[M];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
 		for(int n=0; n<N; n++) {
			numbers[n] = Integer.parseInt(st.nextToken());
		}
 		
 		Arrays.sort(numbers);
 		
 		permutation(0);
 		
 		System.out.println(sb.toString());

	
 		
	}
	
	static void permutation(int cnt) {
		if(cnt ==M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i] ) {
				if(cnt!=0 && result[cnt-1]>=numbers[i]) continue;
				visited[i] = true;
				result[cnt] = numbers[i];
				permutation(cnt+1);
				visited[i] = false;
			}
		}
	}
	

}
