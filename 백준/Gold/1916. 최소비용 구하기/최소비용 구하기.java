import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	static class Node{
		int city;
		long cost;
		Node(int city, long cost){
			this.city = city;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<Node>[] edges = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			edges[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long cost = Long.parseLong(st.nextToken());
			edges[a].add(new Node(b, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> Long.compare(o1.cost, o2.cost));
		long[] dist = new long[N+1];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(dist[cur.city] < cur.cost) continue;
			
			for(Node next : edges[cur.city]) {
				if (next.cost+cur.cost < dist[next.city]) {
					dist[next.city] = next.cost+cur.cost;
					pq.add(new Node(next.city, dist[next.city]));
				}
			}
		}
		
		System.out.println(dist[end]);
		
		
		
	}
}