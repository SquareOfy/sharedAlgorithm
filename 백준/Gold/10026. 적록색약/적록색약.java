import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main{

	static int N;
	static char[][] grid;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		grid = new char[N][N];
		visited = new boolean[N][N];
		int cntA = 0;
		int cntB = 0;

		for(int r=0; r<N; r++) {
			String str = br.readLine();
			for(int c=0; c<N; c++) {
				grid[r][c] = str.charAt(c);
			}
		}
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(!visited[r][c]) {
					DFS(r, c, grid[r][c]);
					cntA++;
				}
			}
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(grid[r][c]=='G') grid[r][c] = 'R';
			}
		}
		
		visited = new boolean[N][N];
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(!visited[r][c]) {
					DFS(r, c, grid[r][c]);
					cntB++;
					
				}
				
			}
		
		}
		
		sb.append(cntA).append(" ").append(cntB);
		System.out.println(sb.toString());
	}
	
	static void DFS(int r, int c, char ch) {
		visited[r][c] = true;
		
		for(int i=0; i<4; i++) {
			int du = r+dr[i];
			int dv = c+dc[i];
			if(du>=0 && du<N && dv>=0 &&dv<N) {
				if(!visited[du][dv] && grid[du][dv]==ch) {
					DFS(du, dv,ch);
				}
			}
		}
	}

}
