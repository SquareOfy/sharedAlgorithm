import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int[] map = new int[N];
		for(int n=0; n<N; n++) {
			map[n] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] num = new int[M];
		for(int m=0; m<M; m++) {
			num[m] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(map);
		for(int m=0; m<M; m++) {
			int start = 0;
			int end = N-1;
			int mid = (start+end)/2;
			while(start<=end && num[m]!=map[mid]) {
				mid = (start+end)/2;
				if(num[m]<map[mid]) {
					end = mid-1;
				
					
				}else {
					start = mid+1;
				}
			
				
				
			}
			if(map[mid]==num[m]) sb.append(1).append("\n");
			else sb.append(0).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}