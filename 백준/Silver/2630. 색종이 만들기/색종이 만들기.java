import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int N;
	static int[][] paper; 
	static int[] cnt = new int[2];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				paper[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		cutPaper(0,0,N);
		
		System.out.println(cnt[0]);
		System.out.println(cnt[1]);
		
		

	}
	static void cutPaper(int r, int c, int len) {
		int num =isOkay(r,c,len);
		if(num== 1 || num==0) {
			cnt[num] ++;
			return;
		}
		
		len = len/2;
		
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				cutPaper(r+len*i, c+len*j, len);
			}
		}
	
		
		
	}
	
	static int isOkay(int r, int c, int len) {
		int temp = paper[r][c];
		for(int i=r; i<r+len; i++) {
			for(int j=c; j<c+len; j++) {
				if(paper[i][j] != temp ) return -1;
 			}
		}
		
		return temp;
		
	}

}
