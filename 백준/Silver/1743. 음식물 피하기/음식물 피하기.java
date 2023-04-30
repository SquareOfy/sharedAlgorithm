import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static int max;
	static int cnt;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0 , -1, 1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		max =0;
		cnt =0;
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] =1;
		}
		
	
		for(int r=1; r<=N; r++) {
			for(int c=1; c<=M; c++) {
				if(!visited[r][c] && map[r][c]==1) {
					DFS(r, c);
					max = Math.max(cnt, max);
					cnt =0;
				}
			}
		}
		System.out.println(max);
	}
	static void DFS(int r, int c) {
		visited[r][c] = true;
		cnt++;
		max = Math.max(cnt, max);

		for(int i=0; i<4; i++) {
			int du = r+dr[i];
			int dv = c+dc[i];
			if(du>=1 && du<=N && dv>=1 && dv<=M) {
				if(!visited[du][dv]&&map[du][dv]==1) {
					DFS(du, dv);
				}
			}
		}
		
	}
}
