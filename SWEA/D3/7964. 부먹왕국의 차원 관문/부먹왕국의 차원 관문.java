import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			boolean[] doors = new boolean[N+2];
			int D = Integer.parseInt(st.nextToken());
		
			st = new StringTokenizer(br.readLine());
			
			doors[0] = true;
			doors[N+1] = true;
			
			for(int n=1; n<=N; n++) {
				if(Integer.parseInt(st.nextToken())==1) 	doors[n] = true;

				}
			

		
			int cnt =0;
			int result =0;
		
			for(int n=1; n<=N+1; n++) {
				
				if(doors[n]) {
					if(cnt >= D) {
						result += cnt/D;
					}
					cnt =0;
		
				
				}
				else if(!doors[n]) {
					cnt ++;
				
					
				}

				
				
			
				
			}
			
			System.out.printf("#%d %d\n", t, result);
			
			
			
		}
		

	}

}