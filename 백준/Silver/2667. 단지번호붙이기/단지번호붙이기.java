import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int cnt;
	static int[] result = new int[25*25+1];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//입력받기
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int r=0; r<N; r++) {
			String str = br.readLine();
			for(int c=0; c<N; c++) {
				map[r][c] = str.charAt(c)-'0';
			}
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(!visited[r][c] && map[r][c]!=0) {
					cnt ++;
					DFS(r, c, cnt, 0);
					
				}
			}
		}
		
		System.out.println(cnt);
		Arrays.sort(result);

		
		for(int i=result.length-cnt; i<result.length; i++) {
			System.out.println(result[i]);
		}
		
		

	}
	
	static void DFS(int r, int c, int cnt, int num) {
		visited[r][c] = true;
		map[r][c] = cnt;
		result[cnt]++;
		
		for(int i=0; i<4; i++) {
			int du = r+dr[i];
			int dv = c+dc[i];
			if(du>=0 && du<N && dv>=0 && dv<N) {
				if(!visited[du][dv] && map[du][dv]!=0) {
					DFS(du, dv, cnt, num+1);
					
			
				}
			}
		}
	}

}
