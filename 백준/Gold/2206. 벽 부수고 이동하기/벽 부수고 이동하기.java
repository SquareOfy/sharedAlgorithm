import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
		static int N;
		static int M;
		static int[][] map;
		static boolean[][][] visited;
		static int[] dr = {-1, 1, 0, 0};
		static int[] dc = {0, 0 , -1, 1};
		static int cnt;
		static int min;
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		//입력 받기
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M]; 
		visited = new boolean[2][N][M]; //이동한 곳 체크할 배열(0은 부수기 사용 전, 1은 부수기 사용 후)

		cnt = 0;
		min = N*M+1;
		for(int r=0; r<N; r++ ) {
			String str = br.readLine();
			for(int c=0; c<M; c++) {
				map[r][c]=(int)str.charAt(c)-'0';
			}
		}
		
		
		BFS(0,0);
		
		if(min != N*M+1) System.out.println(min);
		else System.out.println(-1);
	}
	
	static class Node{
		int row;
		int column;
		int rank;
		boolean flag;
		
		Node(int r, int c, int rank, boolean flag) {
			this.row = r;
			this.column = c;
			this.rank = rank;
			this.flag = flag;
		}


		
		
	}
	
	static void BFS(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(new Node(r,c,1, false));
		visited[0][r][c] = true;
		visited[1][r][c] = true;
		
		
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			if(curr.row==N-1 && curr.column ==M-1) {
				min = Math.min(min,curr.rank);
				break;
			}
			
			for(int i=0; i<4; i++) {
				int du = curr.row +dr[i];
				int dv = curr.column + dc[i];
				

				
				//이동할 위치가 범위를 벗어나지 않으면서
				if(du>=0 && du<N && dv>=0 && dv<M) {
					//아직 아무 벽도 부수기 전 && map 값이 1 && 거길 부순 적이 없을 때 => 부숴봐!!!
					if(!curr.flag && map[du][dv]==1 && !visited[1][du][dv]) {
						queue.add(new Node(du, dv, curr.rank+1, true));
						visited[1][du][dv] = true;
					}
					
					//이전에 어딘가의 벽을 부쉈고, 이동할 위치의 값이 0이면서 방문 전일 때 ! 이동해 !! 
					else if(curr.flag && map[du][dv]==0 && !visited[1][du][dv]) {
						queue.add(new Node(du, dv, curr.rank+1, true));
						visited[1][du][dv] = true;
					}
					//벽 부수기 전이고 이동할 위치의 값이 0이면서 방문 전일 때 이동해!!
					else if(!curr.flag && map[du][dv]==0 && !visited[0][du][dv]) {
						queue.add(new Node(du, dv, curr.rank+1, false));
						visited[0][du][dv] = true;
						//아직 부수기 전이지만 벽 부순 이후에 왔던 길 되돌아가지 않기 위해 같이 true표시
						visited[1][du][dv] = true;
					}
				}
			}
			
			
			
		}
	}

}