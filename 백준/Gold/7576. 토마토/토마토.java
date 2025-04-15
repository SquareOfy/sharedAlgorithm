
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		int M = sc.nextInt();
		int N = sc.nextInt();
		sc.nextLine();
		int[][] map = new int[N][M];
		
		
		Queue<int[]> q = new LinkedList<int[]>();
		Queue<int[]> nq = new LinkedList<int[]>();
		
		int tomato = 0;
		int ripeCnt = 0;
		int day = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(sc.nextLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j]==1) {
					q.add(new int[] {i, j});
				}else if(map[i][j] ==0) {
					tomato++;
				}
			}	
		}
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int i=0; i<4; i++) {
				int du = now[0]+dr[i];
				int dv = now[1]+dc[i];
				
				if (du<0 || du>=N || dv<0 || dv>=M) continue;
				if (map[du][dv]==1 || map[du][dv]==-1) continue;
				map[du][dv] = 1;
				ripeCnt ++;
				nq.add(new int[] {du,dv});
			}
			
			if(q.isEmpty()) {
				q = nq;
				nq = new LinkedList<int[]>();
				day++;
			}
		}
		
		if(ripeCnt != tomato) {
			System.out.println(-1);
		}else {
			System.out.println(--day);
		}
		
	}

}
