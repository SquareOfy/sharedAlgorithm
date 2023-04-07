import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static  BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); ;
	static  StringTokenizer st;
	
	static int T;
	static int N;
	static int K;
	
	static int[][] map;
	static boolean[][][] visited;
	static int[] dr = {-1, 0, 1, 0}; //상 좌 하 우
	static int[] dc = {0, -1, 0, 1};
	static int max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
	 T= Integer.parseInt(br.readLine());
		 
		 for(int t=1; t<=T; t++) {
			 input();
			 int m = findMax();
			 for(int r=0; r<N; r++) {
				 for(int c=0; c<N; c++) {
					 if(map[r][c]==m) {
						 dfs(r,c,0,1, map[r][c]);					 
						 visited[1][r][c] = false;
						 visited[0][r][c]= false;
					 }
				 }
			 }
			 
			 System.out.println("#"+t+" "+max);
			 
		 }
		
		
	}
	
	static int findMax() {
		int m = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				m = Math.max(m, map[i][j]);
			}
		}
		return m;
	}
	static void input() throws IOException {
		
			stk();
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			visited = new boolean[3][N][N];
			max = 0;
			for(int r=0; r<N; r++) {
				stk();
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
		 
	}
	
	static void dfs(int r, int c, int flag, int len, int now) {
		if(flag==0) visited[0][r][c] = true;
		 visited[1][r][c] = true;

	
			max = Math.max(len, max);
	
		
		for(int i=0; i<4; i++) {
			int du = r+dr[i];
			int dv = c+dc[i];
			if(checkRng(du, dv)) {
				//아직 길 깎은 적 없는데, 가고자 하는 곳이 나보다 낮지 않고, K를 빼면 낮아질 때 깎아보기
				if(flag==0 && map[du][dv]>=now && map[du][dv]-K < now && !visited[1][du][dv]) {
					int next = now- 1;
					dfs(du, dv, 1, len+1, next);
					visited[1][du][dv] = false;
				//갈 곳이 나보다 낮은 곳이면 가보기
				
			}else if(map[du][dv]<now && !visited[flag][du][dv]) {
					dfs(du, dv, flag, len+1, map[du][dv]);
					visited[1][du][dv] = false;
					if(flag==0) visited[0][du][dv] = false;
			}
				
			}

		}

	}
	static boolean checkRng(int du, int dv) {
		return du>=0 && dv>=0 && du<N && dv<N;
	}
	
	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}
	
	
	

}
