import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] basket = new int[N+1];
		for(int i=1; i<=N; i++) {
			basket[i] = i;
		}
		for(int m = 0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int begin = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int mid = Integer.parseInt(st.nextToken());
			
			int[] temp = new int[end-begin+1];
			
			for(int i=0; i<end-mid+1 ; i++) {
				temp[i] = basket[mid+i];
			}
		
		
			
			for(int i=0; i<mid-begin; i++) {
				temp[end-mid+1+i] = basket[begin+i];
			}
		
			
			for(int i=0; i<=end-begin; i++) {
				basket[begin+i] = temp[i];
			}
		}
		
		for(int i=1; i<=N; i++) {
			System.out.print(basket[i]+" ");
		}
	}

}