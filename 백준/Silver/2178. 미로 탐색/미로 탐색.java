import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static int[][] map;
	
	static class Node{
		int r;
		int c;
		int cost;
		Node(int r, int c, int cost){
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			String str = sc.nextLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		int answer = bfs(0, 0);
		System.out.println(answer);
		
		
		
	}
	
	public static int bfs(int r, int c) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(r, c, 1));
		boolean[][] visited = new boolean[N][M];
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			if(now.r == N-1 && now.c == M-1) {
				return now.cost;
			}
			
			for(int i=0; i<4; i++) {
				int du = now.r+dr[i];
				int dv = now.c+dc[i];
				
				if(du<0 || du>=N || dv<0 || dv>=M) continue;
				if(visited[du][dv]) continue;
				if(map[du][dv]==0) continue;

				visited[du][dv] = true;
				q.add(new Node(du, dv, now.cost+1));
				
			}
			
		}
		
		return -1;
	}

}
