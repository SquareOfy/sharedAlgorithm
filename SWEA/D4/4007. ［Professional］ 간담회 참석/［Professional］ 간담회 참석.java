import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution{
	static int INF = Integer.MAX_VALUE;
	static PriorityQueue<Node> pq;
	
	static int N, X;
	
	static class Node implements Comparable<Node>{
		int ed;
		int time;
		
		Node(int ed, int time){
			this.ed = ed;
			this.time = time;
		}

		public int compareTo(Node o) {
			return this.time-o.time;
		}

	
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			int M = sc.nextInt();
			X = sc.nextInt();
			
			ArrayList<Node>[] edges1 = new ArrayList[N+1];
			ArrayList<Node>[] edges2 = new ArrayList[N+1];

			for(int i=1; i<=N; i++) {
				edges1[i] = new ArrayList<Solution.Node>();
				edges2[i] = new ArrayList<Solution.Node>();
			}
			for(int i=0; i<M; i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				int t = sc.nextInt();
				edges1[s].add(new Node(e, t));
				edges2[e].add(new Node(s, t));
			}
			
			int answer = Integer.MIN_VALUE;
			int[] dist1 = new int[N+1];
			int[] dist2 = new int[N+1];
			
			pq = new PriorityQueue<Solution.Node>();
			
			dijkstra(dist1, edges1);
			dijkstra(dist2, edges2);
			
			for(int i=1; i<=N; i++) {
				if(dist1[i]>=INF || dist2[i]>=INF) continue;
				answer = Math.max(answer, dist1[i]+dist2[i]);
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		
		}
		System.out.println(sb.toString());
	}
	
	static void dijkstra(int[] dist, ArrayList<Node>[] edges) {
		Arrays.fill(dist, INF);
		dist[X] = 0;
		
		pq.add(new Node(X, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(dist[cur.ed] < cur.time) continue;

			for(Node next : edges[cur.ed]) {
				
				if(dist[next.ed]>next.time+cur.time) {
					dist[next.ed] = next.time+cur.time;
					pq.add(new Node(next.ed, dist[next.ed]));
				}
			}
		}
	}
}