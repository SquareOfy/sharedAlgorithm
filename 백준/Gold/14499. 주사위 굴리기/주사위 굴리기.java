import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int x;
	static int y;
	static int K;
	
	static int[][] map;
	static int[] start = new int[2];
	static int[] order;
	
	static int[] direction;
	static int[] surround;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] dice = new int[7];
		
		direction = new int[] {0, 0, 2, 1, 3}; //동서북남을 동북서남으로 바꿔줌  surround에 접근하기 위함
		surround = new int[] {3,2,4,5}; //밑이 1일 때 동북서남
		int bottom = 1;
		
		int[] dr = {0, 0, 0, -1, 1}; // 동 서 남 북
		int[] dc = {0, 1, -1, 0, 0};
		
		input();
		
	
		for(int k=0; k<K; k++) {
			int i = order[k];
			if(x+dr[i]>=N || x+dr[i]<0 || y+dc[i]>=M || y+dc[i]<0) continue;
			//주사위 이동
			x += dr[i];
			y += dc[i];
			//새로운 bottom 찾기
			bottom = diceChange(i, bottom);
			if(map[x][y]==0) {
				map[x][y] = dice[bottom];
			}else {
				dice[bottom] = map[x][y];
				map[x][y] =0;
			}
			
			System.out.println(dice[7-bottom]);
			
		}
		
		
	}
	
	static int diceChange(int i, int bottom) {
		
		int result = surround[direction[i]];//새로운 bottom을 출력
	//새로운 bottom에 따른 surround 재정비
		//기존 bottom이 동으로 가면 서, 북으로 가면 남, 서로 가면 동, 남으로 가면 북이 됨.
		surround[(direction[i]+2)%4] = bottom;
		surround[direction[i]] = 7-bottom;//반대편
		return result;
	}
	
	static void stk() throws IOException {
		st = new StringTokenizer(br.readLine());
	}
	
	static void input() throws NumberFormatException, IOException {
		stk();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		order = new int[K];
		for(int r=0; r<N; r++) {
			stk();
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		stk();
		for(int k=0; k<K; k++) {
			order[k] = Integer.parseInt(st.nextToken());
		}
		
	}
}