
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt = 0;
		String[] words = new String[N];
		for(int n=0; n<N; n++) {
			words[n] = br.readLine();
		}
		
		for(int i=0 ;i<M; i++) {
			String target = br.readLine();
			for(int n=0; n<N; n++) {
				if(target.equals(words[n])) cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}

}
