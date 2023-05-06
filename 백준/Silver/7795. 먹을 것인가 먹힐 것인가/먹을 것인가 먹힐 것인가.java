
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[] A = new int[N];
			int[] B = new int[M];

			int cnt = 0;
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				A[n] = Integer.parseInt(st.nextToken());

			}

			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				B[m] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(B);

			for (int n = 0; n < N; n++) {
				 int r= find(B, A[n]);
				 if(r!=0) {
					 cnt+=r;
				 }
				 
			}
			
			sb.append(cnt).append("\n");

		}
		System.out.println(sb.toString());

	}

	static int find(int[] B, int num) {
		int start = 0;
		int end = B.length - 1;

		int mid = (start + end) / 2;
		while (start < end) {

		
				if (B[mid] < num) {
					start = mid + 1;
					mid = (start + end) / 2;
				} else {
					end = mid - 1;
					mid = (start + end) / 2;
					}
				
			}

		
		if(B[mid]<num) {
			return mid+1;
		}else {
			return mid;
		}
	}

}
