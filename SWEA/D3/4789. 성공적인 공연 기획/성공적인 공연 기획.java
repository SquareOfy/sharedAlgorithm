import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int cnt =0;
			int result =0;
			String str = sc.next();
			int[] audience = new int[str.length()];
			for(int i=0; i<audience.length; i++) {
				audience[i] = str.charAt(i)-'0';
				if(audience[i]==0) continue;
				if(cnt >= i) {
					cnt += audience[i];
		
				}
				else {
					result+= i-cnt;
					cnt = i+audience[i];
					
			
		
				}
			}
	
			
			System.out.printf("#%d %d \n", t, result);
			
		}

	}

}