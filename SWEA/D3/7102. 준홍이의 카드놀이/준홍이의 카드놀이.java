
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
			int a;
			int b;
			if(N>=M) {
				a = 1+M;
				b = 1+N;
			}else {
				a = 1+N;
				b = 1+M;
			}
			System.out.printf("#%d ",t);
			for(int i=a; i<=b; i++) {
				System.out.printf(i+" ");
			}
			System.out.println();
			
			
		}

	}

}
