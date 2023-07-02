
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int ed;
		int num;
		Node(int ed, int num){
			this.ed = ed;
			this.num = num;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); //도시 수(노드 수) 
		int M = Integer.parseInt(br.readLine()); //버스 수(간선 수) 
//		int[][] adj = new int[N+1][N+1];
	
		
		List<Node>[] adj = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			adj[i] = new ArrayList<>();
		}
		boolean flag = false;
		
		for(int m=0; m<M; m++) {
			st=new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[a].add(new Node(b, c));
		}
		
		final int INF = Integer.MAX_VALUE;
	
		
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int[] dist = new int[N+1];
		boolean[] visited = new boolean[N+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> {
			return o1.num - o2.num;
		});
		
		
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			int now = tmp.ed;
			int nowCost = tmp.num;
			if(nowCost > dist[now]) continue;
			
			for(Node node : adj[now]) {
				if(dist[node.ed] > nowCost+node.num) {
					dist[node.ed]= nowCost+node.num;
					pq.offer(new Node(node.ed, dist[node.ed]));
				}
			}
		}
		


		System.out.println(dist[end]);
	}

}
