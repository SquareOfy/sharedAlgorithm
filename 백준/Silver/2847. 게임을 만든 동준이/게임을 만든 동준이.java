import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] levels = new int[N];
		for(int n=0; n<N; n++) {
			levels[n] = Integer.parseInt(br.readLine());
		}
		
		int cnt =0;
		
		for(int n=N-1; n>0; n--) {
			for(int m=n-1; m>=0; m-- ) {
				if(levels[n]<=levels[m]) {
					int gap = levels[m]-levels[n];
					levels[m] -= gap+1;
					cnt += gap+1;
				}
			}
		}
			

		System.out.println(cnt);
	}
}
