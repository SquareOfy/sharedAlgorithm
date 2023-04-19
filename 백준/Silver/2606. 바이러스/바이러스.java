import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] list; 
	static boolean[] visited;
	static int N;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st; 
		
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		cnt = 0;
		for(int n=1; n<=N; n++) {
			list[n] = new ArrayList<>();
		}
		
		for(int n=0; n<M; n++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		DFS(1);
		System.out.println(cnt);
		
	}
	
	static void DFS(int n) {
		visited[n] = true;
		
		for(int k=0; k<list[n].size(); k++) {
			int r = list[n].get(k);
			if(!visited[r]) {
				cnt++;
				DFS(r);
			}
		}
	}

}