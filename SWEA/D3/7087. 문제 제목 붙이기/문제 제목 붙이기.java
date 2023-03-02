import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		char[] alphabet = {'A', 'B', 'C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q',
				'R','S','T','U','V','W','X','Y','Z'};
		for(int t=1; t<=T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			int[] cntArr = new int[26];
			
			for(int n=0; n<N; n++) {
				char title = br.readLine().charAt(0);
				for(int i=0; i<26; i++) {
					if(title == alphabet[i]) cntArr[i]++;
				}
			}
			
			int cnt =0;
			for(int i=0; i<26; i++) {
				if(cntArr[i] ==0) break;
				else cnt ++;
			}
	
			System.out.printf("#%d %d\n", t, cnt);
			
			
		}

	}

}