import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static int[] count = new int[] { 0, 5, 5, 5, 5, 5 };
	static int squareCnt;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[10][10];
		visited = new boolean[10][10];
		squareCnt = 0;
		
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//5부터 시작하면서 체크
		min = Integer.MAX_VALUE;

		find(0);
		
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
			
			
		

	}
	static void find(int cnt) {
		if(isAllZero()) {
			min = Math.min(min, cnt);
			return;
		}
		int r = -1;
		int c = -1;
		//시작 지점 찾기 (현재 0이 아닌 point잡기)
		outer : for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				if(map[i][j]==1) {
					r=i;
					c=j;
					break outer;
				}
			}
		}
		//0이 아닌 지점을 길이가 1부터 5인 사각형이 모두 가능한지 체크할 것.
		for(int l = 1; l<=5; l++) {
			//길이가 l인 사각형이 이 점으로부터 가능하다면
			if(isSquare(r,c,l) && count[l]>0) {
				//사각형 모양대로 0 만들고, 그 사각형 개수 줄이고, 전체 사용한 사각형 개수 늘리기
				makeZero(r,c,l,0);
				count[l]--;
				//여기 사각형 만들었으니 다음 사각형 찾으러 가기
				find(cnt+1);
				count[l]++;
				makeZero(r,c,l,1);

			}
		}
		
	}

	//기저부분에 활용할 메서드
	//map이 모두 0이면 true반환
	static boolean isAllZero() {
		for(int r=0; r<10; r++) {
			for(int c=0; c<10; c++) {
				if(map[r][c]==1) return false;
				
			}
		}
		return true;
	}

	static boolean isSquare(int r, int c, int len) {
		int result = 0;

		if (r + len - 1 < 10 && c + len - 1 < 10) {
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					if (map[r + i][c + j] == 1)
						result++;
				}
			}
			if (len * len == result)
				return true;
		}

		return false;
	}
	//r,c로부터 길이가 len인 사각형 영역을 k로 채우는 메서드
	static void makeZero(int r, int c, int len, int k) {
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					map[r + i][c + j] = k;
					
				}
			}
	}

}