import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static int[][] list;
	static int N;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());

			list  = new int[N+3][2];
			visited = new boolean[N+3];

			
			
			for(int n=1; n<=N+2; n++) {
				 st = new StringTokenizer(br.readLine());
			
				list[n][0]= Integer.parseInt(st.nextToken());
				list[n][1]= Integer.parseInt(st.nextToken());
			}
			

			BFS();

				 
			}
		}
	static void BFS() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {1, 0});
		visited[1] = true;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int n = now[0];
			if(now[0]==N+2) {
				System.out.println("happy");
				return;
			}

			for(int m=1; m<=N+2; m++) {
				if(n!=m && !visited[m]) {
					int d = Math.abs(list[n][0]-list[m][0])+Math.abs(list[n][1]-list[m][1]);
					if(d<=1000) {
					queue.add(new int[] {m, d});
					visited[m] = true;
					}
				}
			}
			

			
		}
		System.out.println("sad");
		return;
	}

}