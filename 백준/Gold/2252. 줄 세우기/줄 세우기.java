
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] p = new int[N+1];
		List<Integer>[] adj = new ArrayList[N+1];
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i=1; i<=N; i++) {
			adj[i] = new ArrayList<>();
		}
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			p[b] ++;
		}
		
		for(int i=1; i<=N; i++) {
			if(p[i]==0) {
				queue.add(i);
			}
		}
		
		List<Integer> result = new ArrayList<>();
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			result.add(cur);
			
			for(int i=0; i<adj[cur].size(); i++) {
				int next = adj[cur].get(i);
				p[next] --;
				if(p[next]==0) {
					queue.add(next);
				}
			}
		}
		
		for(int i=0; i<result.size(); i++) {
			System.out.print(result.get(i)+" ");
		}
		
		
	}

}
