import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] paper;
	static int N;
	static int[] cnt = new int[3];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//입력받기
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];

		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				paper[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		cutPaper(0, 0, N);
		for(int i=0; i<3; i++) {
			System.out.println(cnt[i]);
		}

	}
	public static void cutPaper(int row, int column, int length) {
		
		//현재 종이가 다 같은 수로 되어 있는지 판단하기
		int num = isFinish(row, column, length);
		
		//3이 아니면 종이가 하나로 통일 됐다는 뜻이므로 카운트 올리고 리턴.
		if(num!=3) {
			cnt[num+1] ++;
			return;
		}
			int div = length/3;
			for(int i= 0; i<3; i++) {
				for(int j=0; j<3; j++) {
					cutPaper(row+i*div, column+j*div, div);
				}
		}
	}
		
		
		
	
	
	public static int isFinish(int row, int column, int length) {
		int comparison = paper[row][column];
		boolean flag = true;
		outer : for(int r=0; r<length; r++) {
			for(int c=0; c<length; c++ ) {
				if(paper[row+r][column+c]!=comparison) {
					flag = false;
					break outer;
				}
			}
		}
		if(flag) {
			return comparison;
			
				
		} else {
			return 3;
		}
	}

}