import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int w;
	static int h;
	static int[][] land;
	static boolean[][] visited;
	static int cnt;

	static int[] dr = { -1, 1, 0, 0, -1, 1, -1, 1 };// 상 하 좌 우 좌상 좌하 우상 우하
	static int[] dc = { 0, 0, -1, 1, -1, -1, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			cnt = 0;
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0)
				break;
			land = new int[h][w];
			visited = new boolean[h][w];
			for (int r = 0; r < h; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < w; c++) {
					land[r][c] = Integer.parseInt(st.nextToken());
				}
			}



			for (int r = 0; r < h; r++) {
				for (int c = 0; c < w; c++) {
					if (!visited[r][c] && land[r][c] == 1) {
						DFS(r, c);
							cnt++;
						}
					}
				}

			System.out.println(cnt);
			}

		}
	

	static void DFS(int r, int c) {
		visited[r][c] = true;
		
		for (int i = 0; i < 8; i++) {
			int du = r+ dr[i];
			int dv = c + dc[i];
			if (du >= 0 && du< h && dv >= 0 && dv< w) {
				if (!visited[du][dv] && land[du][dv]== 1)	DFS(du, dv);
			}

		}

	}

}