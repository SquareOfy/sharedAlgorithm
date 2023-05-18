
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			long[] nums = new long[N];
			st = new StringTokenizer(br.readLine());
			for(int n=0; n<N; n++) {
				nums[n] = Long.parseLong(st.nextToken());
			
			}
		
			long money = 0;
			int idx = N;
			for(int n=N-1; n>=0; n--) {
				if(n>idx) continue;
				for(int m=n-1; m>=0; m--) {
					if(nums[n]>nums[m]) {
						money += nums[n]-nums[m];
						idx = m;
					}else {
						break;
					}
				}
			}
				
		
			System.out.println(money);
			
			
			
		}
	}

}
