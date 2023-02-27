import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[] minute = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			minute[i] = Integer.parseInt(st.nextToken());
			
		}
		
		Arrays.sort(minute);
		
		for(int i=1; i<N; i++) {
			minute[i] = minute[i] + minute[i-1];
		}
		
		for(int i=1; i<N; i++) {
			minute[i] = minute[i] + minute[i-1];
		}
		
		
		System.out.println(minute[N-1]);

	}

}
