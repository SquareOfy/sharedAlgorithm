import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] grid = new int[1001][1001];
		int N = Integer.parseInt(br.readLine());
		
		int[][] paper = new int[N][4];
		int[] result = new int[N];
		
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0; m<4; m++) {
				paper[n][m] = Integer.parseInt(st.nextToken());
				
			}
			for(int r = paper[n][1]; r<paper[n][1]+paper[n][3]; r++) {
				for(int c= paper[n][0]; c<paper[n][0]+paper[n][2]; c++) {
					if(n==0) {
						grid[r][c]=n+1;
						result[n]++;
					}else {
						if(grid[r][c]!=0) {
							result[grid[r][c]-1]--;
						}
							grid[r][c]=n+1;
							result[n]++;
						}
					}
						
				}
			}
			
			for(int i=0; i<N; i++) {
				System.out.println(result[i]);
				
		}
			
			
			
	}
		
		
		
	

}
