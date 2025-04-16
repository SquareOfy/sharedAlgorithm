
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Node{
		int room;
		long dist;
		Node(int room, long dist){
			this.room = room;
			this.dist = dist;
		}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long answer = 0;
		
		//간선 리스트 정의 & 입력받기
		ArrayList<Node>[] edges = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			edges[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<N-1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			long c = sc.nextLong();
			edges[a].add(new Node(b, c));
			edges[b].add(new Node(a, c));
		}
		
		//방문배열
		boolean[] visited = new boolean[N+1];
		visited[1] = true;
		
		//bfs
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(1, 0));
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			
			for(Node next : edges[now.room]) {
				if(visited[next.room]) continue; //방문한 경우

				answer = Math.max(now.dist+next.dist, answer);
				visited[next.room] = true;
				queue.add(new Node(next.room, now.dist+next.dist));
			}
		}
		
		System.out.println(answer);
	}

}
