import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static class Tomato {
		int row;
		int column;
		int rank;
		
		Tomato(int r, int c, int rank){
			this.row= r;
			this.column =c;
			this.rank = rank;
		}
	}
	
	static int M;
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static Queue<Tomato> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		visited = new boolean[M][N];
		int max = -1;
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			for(int n=0; n<N; n++) {
				map[m][n] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int m=0; m<M; m++) {
			for(int n=0; n<N; n++) {
				if(map[m][n]==1) {
					queue.add(new Tomato(m,n,0));
					visited[m][n] = true;
				}
			}
		}
				
				max = BFS();
				
				
				
			
		
		if(check()) System.out.println(max);
		else System.out.println(-1);
		
		
		
		
		
	}
	
	static boolean check() {
		for(int m=0; m<M; m++) {
			for(int n=0; n<N; n++) {
				if(map[m][n]==0 && !visited[m][n]) return false;
			}
		}
		return true;
	}

	static int BFS() {
		int result = 0;

		while(!queue.isEmpty()) {
			Tomato curr = queue.poll();
			for(int i=0; i<4; i++) {
			int du = curr.row + dr[i];
			int dv = curr.column + dc[i];
			if(du>=0 && du<M && dv>=0 && dv<N) {
				if(!visited[du][dv]&&map[du][dv]==0) {
					int rank = curr.rank;
					queue.add(new Tomato(du, dv, rank+1));
					visited[du][dv] = true;
					result = Math.max(result, rank+1);
				}
			}
			
			}
		}
		
		return result;
	}
	
	


}


