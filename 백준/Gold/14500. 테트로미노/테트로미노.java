import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static int max;
	static int[] except;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		//ㅜ모양을 제외하고 확인
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				visited[r][c] = true;
				DFS(r,c,1,map[r][c]);
				visited[r][c] = false;
			}
		}
		
		//ㅜ,ㅗ,ㅏ,ㅓ모양 확인하기
		except = new int[4];
 		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				for(int k=0; k<4; k++) {
					exceptCheck(r,c,k);
					max = Math.max(max, except[k]);
				}
			
			}
		}
		
		
		System.out.println(max);
		
	}
	
	static void exceptCheck(int r, int c, int num) {
		switch(num) {
		case(0): //ㅜ
			if(c+2<M && r+1<N) {
				except[0] = map[r][c]+map[r][c+1]+map[r][c+2]+map[r+1][c+1];
				
			}
		case(1)://ㅗ
			if(c-1>=0 && c+1<M && r+1<N) {
				except[1] = map[r+1][c-1]+map[r+1][c]+map[r+1][c+1]+map[r][c];
			}
		case(2): //ㅏ
			if(c+1<M && r+2<N) {
				except[2] = map[r][c]+map[r+1][c]+map[r+1][c+1]+map[r+2][c];
			}
		
		case(3)://ㅓ
			if(r+2<N && c-1>=0) {
				except[3]= map[r][c]+map[r+1][c]+map[r+1][c-1]+map[r+2][c];
			}
		}
	
	}
	
	
	static void DFS(int r, int c, int cnt, int num) {
		if(cnt == 4) {
			max = Math.max(max, num);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int du = r+dr[i];
			int dv = c+dc[i];
			
			if(du>=0 && du<N && dv>=0 && dv<M) {
				if(!visited[du][dv]) {
					visited[du][dv] = true;
					DFS(du, dv, cnt+1, num+map[du][dv]);
					visited[du][dv] = false;
				}
			}
		}
		
	}
}