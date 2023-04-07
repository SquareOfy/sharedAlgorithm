import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int V;
	static int E;
	static int[] p;
	static int[][] edges;
	static long result;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			input();
			
		for(int i=1; i<=V; i++) {
			makeSet(i);
		}
        result = 0;
		cnt =0;
		Kruskal();
	
		System.out.println("#"+t+" " + result);
			
		}
		
	}
	static void sort() {
		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
	}
	
	static void Kruskal() {
		sort();
		
		for(int i=0; i<E; i++) {
			int px = findSet(edges[i][0]);
			int py = findSet(edges[i][1]);
			
			if(px != py) {
				union(px,py);
				result+= edges[i][2];
				cnt++;
			}
			
			if(cnt == V-1) break;
		}
	}
	
	static void union(int px, int py) {
		p[py] = p[px];
	}
	
	static void makeSet(int i) {
			p[i] = i;
		
	}
	
	static int findSet(int x) {
		if(x!=p[x]) p[x] = findSet(p[x]);
		return p[x];
	}
	
	static void input() throws IOException {
		stk();
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		edges = new int[E][3];
		p = new int[V+1];
		
		for(int i=0; i<E; i++) {
			stk();
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
			edges[i][2] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}
	
	

}
