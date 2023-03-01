import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
				
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			int[] A = new int[Integer.parseInt(st.nextToken()+1)];
			while(st.hasMoreTokens()) {
				A[Integer.parseInt(st.nextToken())]++;
			}
			
			st = new StringTokenizer(br.readLine());
			int[] B = new int[Integer.parseInt(st.nextToken()+1)];
			while(st.hasMoreTokens()) {
			
				B[Integer.parseInt(st.nextToken())]++;
			}
			for(int i=5; i>0; i--) {
				if(A[i]>B[i]) {
					System.out.println("A");
					break;
					
				}else if(A[i]<B[i]) {
					System.out.println("B");
					break;
				}
				
				if(i==1 & A[i]==B[i]) 	System.out.println("D");
				
				
			}
		}
		
	}

}