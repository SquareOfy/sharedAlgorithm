
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int[] p;
	static int[] rank;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		p = new int[N+1];
		rank = new int[N+1];
		for (int i=1; i<=N; i++) {
			p[i] = i;
		}
		
		int M = Integer.parseInt(st.nextToken());
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(op==0) {
				union(a, b);
			}else if(isSameSet(a,b)) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			}
			
		}
		
	
	
	public static void union(int a, int b) {
		int x = findSet(a);
		int y = findSet(b);
		if(rank[x] > rank[y]) {
			p[x] = y;
		}else {
			p[x]=y;
			if(rank[x]==rank[y]) {
				rank[y]++;
			}
		}
	}
	
	static int findSet(int x) {
		if(x!=p[x]) {
			p[x]=findSet(p[x]);
		}
		return p[x];
	}
	
	public static boolean isSameSet(int a, int b) {
		if(findSet(a)==findSet(b)) {
			return true;
		}
		return false;
	}

}


