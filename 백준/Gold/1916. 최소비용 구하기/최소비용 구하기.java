import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); //도시 수(노드 수) 
		int M = Integer.parseInt(br.readLine()); //버스 수(간선 수) 
		int[][] adj = new int[N+1][N+1];
		for(int i=1; i<N+1; i++) {
			
			Arrays.fill(adj[i], -1);
		}
		for(int m=0; m<M; m++) {
			st=new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
		
			if(adj[a][b]!= -1 && adj[a][b]<c) continue;
			adj[a][b]=c;
		
		}
		
		final int INF = Integer.MAX_VALUE;
	
		
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int[] dist = new int[N+1];
		boolean[] visited = new boolean[N+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		
		for(int n=1; n<=N; n++) {
			int current = -1;
			int min = INF;
			
			for(int i=1; i<=N; i++) {
				if(!visited[i] && min>dist[i]) {
					min = dist[i];
					current = i;
				}
			}
			
			if(current == -1) {
	
				break;
			}
			visited[current] = true;
			
			for(int i=1; i<=N; i++) {
				if(!visited[i] && adj[current][i] != -1 && dist[i] > min+adj[current][i]) {
					dist[i] = min + adj[current][i];
					}
			}
			
		}
	
		
		System.out.println(dist[end]);
	}

}
