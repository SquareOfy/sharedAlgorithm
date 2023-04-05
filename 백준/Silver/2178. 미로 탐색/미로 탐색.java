
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Integer[]> queue = new LinkedList<Integer[]>();
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+2][M+2];
		visited = new boolean[N+2][M+2];
		cnt = 0;
		for(int r=1; r<=N; r++ ) {
			String str = br.readLine();
			for(int c=1; c<=M; c++) {
				map[r][c]=str.charAt(c-1)-'0';
			}
		}
		
		BFS(1,1);
	
		
	}
	
	static void BFS(int r, int c) {
		queue.add(new Integer[] {r, c, 1});
		visited[r][c] = true;
	
		
		while(!queue.isEmpty()) {
			Integer[] curr = queue.poll();
			
			for(int i=0; i<4; i++) {
				int du = curr[0]+dr[i];
				int dv = curr[1]+dc[i];
				if(map[du][dv] ==1 && !visited[du][dv]) {
					queue.add(new Integer[] {du, dv, curr[2]+1});
					visited[du][dv] = true;

					if(du==N && dv==M) {
						System.out.println(curr[2]+1);
						break;
					}
				}
			}
			
		}
		
	}

}
