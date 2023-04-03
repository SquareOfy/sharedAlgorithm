import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[][] adj;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		adj = new int[N+1][N+1];
		visited = new boolean[N+1];
	
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			adj[start][end] = adj[end][start] = 1;
		}
		
		DFS(V);
		System.out.println();
		BFS(V);
	}

	static void DFS(int v) {
		visited[v] = true;
		System.out.print(v+" ");
		
		for(int i=1; i<=N; i++) {
			if(!visited[i] && adj[v][i]==1) {
				DFS(i);
			}
		}
		
	}
	
	static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();
		visited = new boolean[N+1];
		queue.add(v);
		visited[v] = true;
		
		while(!queue.isEmpty()) {
			int w = queue.poll();
			System.out.print(w+" ");
			for(int i=1; i<=N; i++) {
				if(!visited[i] && adj[w][i]==1) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
}