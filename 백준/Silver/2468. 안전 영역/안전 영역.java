
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0 , -1, 1}; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		int maxH = 0;
		int minH = 100;
		
		int max=1;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int r=0; r<N; r++) {
			maxH = Math.max(Arrays.stream(map[r]).max().getAsInt(), maxH);
			minH = Math.min(Arrays.stream(map[r]).min().getAsInt(), minH);
		}
		
		int cnt =0;
		for(int h= minH; h<=maxH; h++) {
			cnt = 0;
			visited = new boolean[N][N];
			flood(h, true);
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(!visited[r][c]) {
						DFS(r, c);
						cnt++;

					}
						
				}
			}

			max = Math.max(max, cnt);

		}
		
		System.out.println(max);
		
		
		
		
		
		
	}
	static void DFS(int r, int c) {
		visited[r][c] = true;
		
		for(int i=0; i<4; i++) {
			int du = r+ dr[i];
			int dv = c+ dc[i];
			
			if(du>=0 && du<N && dv>=0 && dv<N) {
				if(!visited[du][dv]) {
					DFS(du, dv);
				}
			}
		}
	}
	
	static void flood(int h, boolean check) {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c]<=h) visited[r][c] = check;
			}
		}
	}

}
