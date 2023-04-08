import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int B;
	static int C;
	
	static int[] map;
	
	static void input() throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			map[n] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		long cnt = 0;
		for(int n=0; n<N; n++) {
			map[n] -= B;
		}
		cnt += N;
		
		for(int n=0; n<N; n++) {
			if (map[n] >0) {
				cnt += map[n] / C;
				if(map[n]%C != 0) cnt ++;
			}
		
		}
		
		System.out.println(cnt);
		
		

	}

}