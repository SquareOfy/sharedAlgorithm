
import java.util.Arrays;
import java.util.Scanner;

public class Solution{
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<11; tc++) {
			int t = sc.nextInt();
			String p = sc.next();
			String s = sc.next();
			int ans = kmp(s, p);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
		
		
	}
	static int kmp(String s, String p) {
		int result = 0;
		int[] pi = getPi(p);
		int n = s.length();
		int m = p.length();
		int j = 0;
		
		for(int i=0; i<n; i++) {
			while(j>0 && s.charAt(i)!=p.charAt(j)) {
				j = pi[j-1];
			}
			
			if(s.charAt(i) == p.charAt(j)) {
				if(j==m-1) {
					result++;
					j = pi[j];
				}else {
					j++;
				}
			}
		}
		
		return result;
	}

	static int[] getPi(String p) {
		int len = p.length();
		int[] pi = new int[len];
		int j = 0;
		
		for(int i=1; i<len; i++) {
			while(j>0 && p.charAt(i)!=p.charAt(j)) {
				j = pi[j-1];
			}
			if(p.charAt(i)==p.charAt(j)) {
				pi[i]= ++j;
			}
		}
		return pi;
	}
}