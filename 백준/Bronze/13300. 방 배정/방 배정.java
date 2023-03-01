import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] cntW = new int[7];
		int[] cntM = new int[7];
 		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			if(gender ==0) cntW[Integer.parseInt(st.nextToken())]++;
			else cntM[Integer.parseInt(st.nextToken())]++;
			
		}
		int result =0;
		for(int i=1; i<=6; i++) {
			result += cntW[i]/K+cntM[i]/K;
			
			if(cntW[i]%K !=0) result ++;
			if(cntM[i]%K !=0) result ++;
		}
		
		System.out.println(result);

	}

}