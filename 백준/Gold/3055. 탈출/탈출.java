import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int row;
		int column;
		int rank;

		Node(int row, int column, int rank) {
			this.row = row;
			this.column = column;
			this.rank = rank;

		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int R;
	static int C;

	static int[] start = new int[2];
	static int[] end = new int[2];

	static char[][] map;
	static boolean[][][] visited;

	static Queue<Node> water = new LinkedList<>();
	static Queue<Node> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[2][R][C];

		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
				if (map[r][c] == 'S') {
					start[0] = r;
					start[1] = c;
				} else if (map[r][c] == 'X') {
//					visited[0][r][c]=true;
//					visited[1][r][c]=true;
					
				} else if (map[r][c] == '*') {
					water.add(new Node(r, c, 0));
					visited[1][r][c] = true;
				}
			}
		}

		int result = BFS(start[0], start[1]);

		if (result == -1) {
			System.out.println("KAKTUS");
	}
		else {
			System.out.println(result);
		}
	}
	static void flood(int nowRank) {
		while (!water.isEmpty() && water.peek().rank < nowRank) {
			Node f = water.poll();
			for (int i = 0; i < 4; i++) {
				int du = f.row + dr[i];
				int dv = f.column + dc[i];
				if (du >= 0 && dv >= 0 && du < R && dv < C) {
					if (!visited[1][du][dv] && map[du][dv] == '.') {
		
						water.add(new Node(du, dv, f.rank + 1));
						visited[1][du][dv] = true;
					}
				}
			}
		}
	
	}

	static int BFS(int r, int c) {
		visited[0][r][c] = true;
		queue.add(new Node(r, c, 0));

		while (!queue.isEmpty()) {
			Node now = queue.poll();
			// 같은 rank에 있는 물 모두 확장하기
			flood(now.rank);

			for (int i = 0; i < 4; i++) {
				int du = now.row + dr[i];
				int dv = now.column + dc[i];
				if (du >= 0 && dv >= 0 && du < R && dv < C) {

					flood(now.rank+1);
					if (map[du][dv]=='D') {
						//S도착했으면
							return now.rank + 1;
						}
			
					if (!visited[0][du][dv] && map[du][dv] != 'X') 
						if( !visited[1][du][dv] ) {
						queue.add(new Node(du, dv, now.rank + 1));
						visited[0][du][dv] = true;
						
					}
				}
			}
		}

		

		return -1;
	}

}