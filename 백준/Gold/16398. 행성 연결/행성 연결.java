
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

	static int[] p;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int N = Integer.parseInt(br.readLine());
		
		
		int[][] adj = new int[N][N];
		boolean[] visited = new boolean[N];
		int[] p = new int[N];
		int[] dist = new int[N];
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				adj[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		int INF = Integer.MAX_VALUE;
		Arrays.fill(dist, INF); 
		
		dist[0] = 0;
		p[0] = -1; 
		
		long ans = 0;
		
		for(int i=0; i<N; i++) {
			int min = INF;
			int idx = -1;
			
			for(int j=0; j<N; j++) {
				if(!visited[j] && dist[j]<min) {
					min = dist[j];
					idx = j;
				}
			}
			
			visited[idx] = true;
			
			for(int j=0; j<N; j++) {
				if(!visited[j]&&adj[idx][j]!=0 && dist[j]>adj[idx][j]) {
					dist[j]=adj[idx][j];
					p[j]=idx;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			ans+=dist[i];
		}
		
		System.out.println(ans);
		
		
	}
	
	

}
