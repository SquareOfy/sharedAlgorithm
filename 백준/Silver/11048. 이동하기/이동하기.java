import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;
	static int N;
	static int M;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dp = new int[2][3];
		map = new int[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(operation());
		

	}
	
	static int operation() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				dp[0][0] = map[i-1][j];
				dp[0][1] = map[i][j-1];
				dp[0][2] = map[i-1][j-1];
	
				map[i][j] += Arrays.stream(dp[0]).max().getAsInt();
				
		
			}
		}
		
		return map[N][M];
		
	}

}
