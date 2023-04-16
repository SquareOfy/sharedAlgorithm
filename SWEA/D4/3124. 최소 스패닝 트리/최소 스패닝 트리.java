import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static class Node{
		int st;
		int ed;
		int num;
		
		Node(int ed, int num){
			this.ed = ed;
			this.num = num;
		}
	}
	
	static int V;
	static int E;
	static int inf = Integer.MAX_VALUE;
	static int[] dist;
	static List<Node>[] list;
	static boolean[] visited;
 	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			list = new ArrayList[V+1];
			dist = new int[V+1];
			visited = new boolean[V+1];
			long answer = 0;
			
			for(int v=1; v<=V; v++) {
				list[v] = new ArrayList<>();
			}
			for(int e=0; e<E; e++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				list[start].add(new Node(end, num));
				list[end].add(new Node(start, num));
				
			}
			
			Arrays.fill(dist, inf);
			
			dist[0] = 0;
			PriorityQueue<Node> queue= new PriorityQueue<>(new Comparator<Node>() {

				@Override
				public int compare(Node o1, Node o2) {
					
					return o1.num - o2.num;
				}
			});
			for(int i=0; i<list[1].size(); i++) {
				queue.add(list[1].get(i));
			}
			visited[1] = true;
			for(int v=1; v<V; v++) {
				int idx = -1;
				int min = inf;
				while(true) {
					Node n = queue.poll();
					if(!visited[n.ed]) {
						idx = n.ed;
						visited[idx] = true;
						min = n.num;
						break;
					}
				}
				answer+= min;
				

				for(Node x : list[idx]) {
					if(!visited[x.ed]) queue.add(x);
				}
			
				
				
				
			}
		
			
			System.out.println("#"+t+" "+ answer);
			
			
		}

	}

}
