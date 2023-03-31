import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int L ;
	static int C ; 
	static char[] alphabet ;
	static char[] result;
	static boolean[] visited;
	static HashSet<Character> vowel = new HashSet<>(Arrays.asList('a','e','i','o','u'));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken()); //암호의 길이
		C = Integer.parseInt(st.nextToken()); //제시될 알파벳의 개수
		alphabet = new char[C]; 
		visited = new boolean[C];
		result = new char[L];
		st = new StringTokenizer(br.readLine());
		for(int c=0; c<C; c++) {
			alphabet[c] = st.nextToken().charAt(0);
		}
		Arrays.sort(alphabet);
		makeCode(0);
	
		
	
	}

	public static void makeCode(int cnt) {
		if(cnt == L) {
			int vowelCnt =0;
			for(int i=0; i<L; i++) {
				if(vowel.contains(result[i])) {
					vowelCnt++;
				}
			}
			
			
			if(vowelCnt>=1 && L-vowelCnt>=2) {
			for(int i=0; i<L; i++) {
				System.out.print(result[i]);
				if(i==L-1) System.out.println();
			}
			}
			return;
		}
		
		for(int c=0; c<C; c++) {
			if(!visited[c]) {
				if(cnt!=0 && (int)result[cnt-1]>(int)alphabet[c]) continue;
				visited[c] = true;
				result[cnt] = alphabet[c];
				makeCode(cnt+1);
				visited[c] = false;
			}
		}
		
		
		
	}
	
}