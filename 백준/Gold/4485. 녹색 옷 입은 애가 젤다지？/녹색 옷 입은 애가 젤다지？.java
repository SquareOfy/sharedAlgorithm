import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static class Node implements Comparable<Node>{
		int r;
		int c;
		int cost;
		
		Node(int r, int c, int cost){
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		public int compareTo(Node o) {
			
			return this.cost - o.cost;
		}

		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N;
		int[][] map;
		int[][] dist;
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, -1, 0, 1};
		
		PriorityQueue<Node> pq;
		int t = 0;
		while(true) {
			N = sc.nextInt();
			if (N==0) break;
			t++;
			
			map = new int[N][N];
			dist = new int[N][N];
			
			for(int i=0; i<N; i++) {
				
				Arrays.fill(dist[i], Integer.MAX_VALUE);
				
				for (int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			pq = new PriorityQueue<Node>();
			dist[0][0] = map[0][0];
			pq.add(new Node(0, 0, map[0][0]));
			
			while(!pq.isEmpty()) {
				Node cur = pq.poll();
				if (cur.r==N-1 && cur.c ==N-1) {
					sb.append("Problem ").append(t).append(": ").append(cur.cost).append("\n");
				}
				for(int i=0; i<4; i++) {
					int du = cur.r+dr[i];
					int dv = cur.c+dc[i];
					if(du<0 || dv<0 || du>=N || dv>=N) continue;
					
					if(dist[du][dv]>cur.cost+map[du][dv]) {
						dist[du][dv] = cur.cost + map[du][dv];
						pq.add(new Node(du, dv, dist[du][dv]));
					}
					
				}
			}	
		
		}
		System.out.println(sb.toString());
	}
	

}
