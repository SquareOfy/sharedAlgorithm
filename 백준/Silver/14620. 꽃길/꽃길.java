import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] checked;
	static int[][] result = new int[3][2];
	static int sum = 0;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		 N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		checked = new boolean[N][N];
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		find(0);
		System.out.println(min);
		
		
	}

	public static void find(int cnt) {
		if(cnt ==3) {

			if(sum<min) min=sum;
			return;
		}
		for(int r=1; r<N-1; r++) {
			for(int c=1; c<N-1; c++) {
				if(!checked[r][c] && !checked[r-1][c] && !checked[r+1][c]&& !checked[r][c-1] && !checked[r][c+1]) {
					checked[r][c] = checked[r-1][c] = checked[r+1][c] = checked[r][c-1] = checked[r][c+1] = true; //꽃 심은 부분 + 꽃잎 부분 표시	
					result[cnt][0] = r;
					result[cnt][1] = c; //내가 심은 위치 저장하고
					sum += (map[r][c] + map[r-1][c] + map[r+1][c] + map[r][c-1] + map[r][c+1]);
					find(cnt+1); //다음 위치 찾으러 가고
					sum -=(map[r][c] + map[r-1][c] + map[r+1][c] + map[r][c-1] + map[r][c+1]);
					checked[r][c] = checked[r-1][c] = checked[r+1][c] = checked[r][c-1] = checked[r][c+1] = false; //꽃 심었다는 걸 해제
				}
			 }
		}
	}
		
		
		
	}