import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Integer[] trees = new Integer[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			
		}
		
		Arrays.sort(trees, Collections.reverseOrder());
		int[] days = new int[N];
		for(int i=0; i<N; i++ ) {
			days[i] = trees[i]+i+2;
			
		}

		System.out.println(Arrays.stream(days).max().getAsInt());
		
		
	}

}
