import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static 	List<Integer>[] list;
	static int N;
	static int cnt;
	static int a;
	static int b;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		cnt =0;
		visited = new boolean[N+1];
		list = new ArrayList[N+1];
		
		for(int n=1; n<=N; n++) {
			list[n] = new ArrayList<>();
		}
		
		
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list[x].add(y);
			list[y].add(x);
		}
		
		System.out.println(BFS());
		
	}
	
	
	static int BFS() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {a,0});
		visited[a] = true;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int rank = now[1];
	
			for(int i =0; i<list[now[0]].size(); i++) {
				int num = list[now[0]].get(i);
				if(num==b) 
					return rank+1;
				if(!visited[num]) {
					queue.add(new int[] {num, rank+1});
					visited[num] = true;
				}
			}
		
	}
		return -1;
	}

}