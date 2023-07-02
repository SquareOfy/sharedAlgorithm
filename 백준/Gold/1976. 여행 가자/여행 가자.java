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
		
		int N  = Integer.parseInt(br.readLine());
		
		int M = Integer.parseInt(br.readLine());
		
		int[][] adj = new int[N][N];
		//makeSet()
		p = new int[N];
		for(int n=0; n<N; n++) {
			p[n] = n;
		}
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				adj[r][c] = Integer.parseInt(st.nextToken());
				if(r>c && adj[r][c]!=0 ) union(r, c);
			}
		
		}
		
		for(int n=0; n<N; n++) {
			p[n] = findSet(n);
		}
		
		int[] plan = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int m=0; m<M; m++) {
			plan[m] = Integer.parseInt(st.nextToken())-1;
		}
		int standard = p[plan[0]];
		boolean flag = false;
		for(int m=0; m<M; m++) {
			if(standard != p[plan[m]] ) flag = true;
		}
		
		if(flag) System.out.println("NO");
		else System.out.println("YES");
	
	
		
		
	}
	
	static int findSet(int x) {
		if(p[x]==x) return x;
		return findSet(p[x]);
	}

	static void union(int x, int y) {
		int py = findSet(y);
		int px = findSet(x);
		p[py] = p[px];
	}
}
