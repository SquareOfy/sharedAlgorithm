import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=10; tc++) {
			
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			int[] d = new int[V+1];
			ArrayList<Integer>[] edges = new ArrayList[V+1];
			for(int i=1; i<=V; i++) {
				edges[i] = new ArrayList<Integer>();
			}
			
			for(int i=0; i<E; i++) {
				int st = sc.nextInt();
				int ed = sc.nextInt();
				edges[st].add(ed);
				d[ed] ++;
			}
			sb.append("#").append(tc).append(" ");
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			
			for(int i=1; i<=V; i++) {
				if(d[i]==0) pq.add(i);
			}
			while(!pq.isEmpty()) {
				int now = pq.poll();
				sb.append(now).append(" ");
				for(int v : edges[now]) {
					d[v]--;
					if(d[v]==0) pq.add(v);
				}
			}
			sb.append("\n");			
		}
		System.out.println(sb.toString());
	}
	
	
}