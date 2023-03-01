import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] seq = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			seq[n] = Integer.parseInt(st.nextToken());
			
		}
		
		int max=0;
		for(int i=0; i<N-K+1; i++) {
			int sum =0;
			for(int j=0; j<K; j++) {
				sum += seq[i+j];
				
			}
			if(i==0 ||(i!=0 && max<sum)) max =sum;
		}
		
		System.out.println(max);
		
		
		
		
	}

}
