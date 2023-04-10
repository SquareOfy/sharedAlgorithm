
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N; //행
	static int M; //열
	
	static int R; //맨홀 위치 (행)
	static int C; //맨홀 위치 (열)
	
	static int L; //시간
	
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	
	static int cnt;
	//터널 구조물 번호에 따라 상좌하우 중 이동 가능한 위치만 1로 표기
	static int[][] type = {{0,0,0,0}, {1,1,1,1}, {1,0,1,0},{0,1,0,1},{1,0,0,1},{0,0,1,1},{0,1,1,0},{1,1,0,0}};
	
	static class Node{
		int row;
		int column;
		int rank;
		
		Node(int r, int c, int rank){
			this.row = r;
			this.column = c;
			this.rank = rank;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//입력
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			cnt = 0;
			
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<M; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
		//입력 종료
			
			
			BFS();
			
			System.out.println("#"+t+" "+ cnt);
			
			
		}

	}
	
	static void BFS() {
		Queue<Node> queue = new LinkedList<>();
		
		visited[R][C] = true;
		queue.add(new Node(R,C,1));
		cnt++;
		
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			int num = map[now.row][now.column];

			
			if(now.rank ==L) {
				return;
			}
			for(int i=0; i<4; i++) {
				
				if(type[num][i]!=0) {
					int du = now.row + dr[i]*type[num][i];
					int dv = now.column + dc[i]*type[num][i];
					if(du>=0 && dv>=0 && du<N && dv<M ) {

						if(!visited[du][dv] && type[map[du][dv]][(i+2)%4]!=0) {
							visited[du][dv]=true;
							cnt ++;
							
							queue.add(new Node(du, dv, now.rank+1));
					
							
						}
					}
				}
			}
			
		}
	}

}
