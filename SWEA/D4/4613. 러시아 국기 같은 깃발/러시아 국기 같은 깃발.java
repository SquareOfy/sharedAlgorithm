import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			char[][] colors = new char[N][M];
			for(int n=0; n<N; n++) {
				String str = br.readLine();
				for(int m=0; m<M; m++) {
					colors[n][m] = str.charAt(m);
				}
			}
			//6줄이면
			//1,1,4 // 1,2,3 // 1,3,2 // .. 다 ~~~~~~~~~~~~~~해보는거지 ! 그 중 최솟값
			
			int min = N*M;
			int cnt =0;
			//i : 흰색 줄 개수  j: 파랑 줄 k : 빨간 줄 개수
			for(int i=1; i<N-1; i++) {
				for(int j=1; j<N-i; j++) {
					
					cnt =0;
						for(int r=0; r<N; r++) {
							for(int c=0; c<M; c++) {
								//흰색 줄 변경
								if(r<i && colors[r][c]!='W') 
									cnt++;
								
								else if(r>=i+j&& colors[r][c] !='R') 
									cnt++;
																
								else if(r>=i && r< i+j && colors[r][c] != 'B') 
									cnt++;
								
								
								
							}
							}
					
						
						if(cnt<min) min=cnt;
						}
					}
			
			
			System.out.printf("#%d %d\n", t,min);
				}
			}
			
			
			
	

					

}