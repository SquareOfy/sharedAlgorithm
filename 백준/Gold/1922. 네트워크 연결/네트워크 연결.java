
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int N; //노드 수
	static int M; //간선 수
	static int[] p;
	
	static long result;
	static int cnt;
	
	static int[][] edges;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		edges = new int[M][3];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
			edges[i][2] = Integer.parseInt(st.nextToken());
		}
		p = new int[N+1];
		for(int i=1; i<=N; i++) {
			p[i] = i;
		}
		
		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return o1[2]-o2[2];
			}
		});
		
		
		Kruskal();
		
		System.out.println(result);
	}
	static void Kruskal() {
		for(int i=0; i<M; i++) {
			int px = findSet(edges[i][0]);
			int py = findSet(edges[i][1]);
			
			if(px!=py) {
				union(px, py);
				result+= edges[i][2];
				cnt++;
			}
			
			if(cnt == N-1) break;
		}
		
	}
	
	static int findSet(int x) {
		if(x != p[x]) p[x] = findSet(p[x]);
		return p[x];
	}
	
	static void union(int x, int y) {
		p[y] = x;
	}
	
	

}
