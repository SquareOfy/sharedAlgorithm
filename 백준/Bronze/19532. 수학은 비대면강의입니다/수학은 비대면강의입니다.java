
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		
		int X = 0;
		int Y = 0;
		for(int x=-999; x<1000; x++) {
			for(int y=-999; y<1000; y++) {
				if(a*x + b*y == c) {
					if(d*x + e*y == f) {
						X = x;
						Y = y;
					}else {
						continue;
					}
				}
			}
		}
		
		System.out.println(X+ " "+ Y);
		
	}

}
