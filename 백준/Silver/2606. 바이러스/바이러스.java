import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		ArrayList<Integer>[] adj = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			adj[i] = new ArrayList<>();
		}
		boolean[] visited = new boolean[N+1];
		
		
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj[a].add(b);
			adj[b].add(a);
		}
		
		Queue<Integer> q = new LinkedList<>();
		int answer = 0;
		
		visited[1] = true;
		q.add(1);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int next : adj[now]) {
				if(visited[next]) continue;
				answer ++;
				visited[next] = true;
				q.add(next);
			}
		}
		
		System.out.println(answer);
	}
	

}