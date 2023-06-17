
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		int idx = -1;

		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt =0;
		while(idx!=0) {
			idx = findMaxIdx(arr);
			if(idx==0) break;
			arr[idx]--;
			arr[0]++;
			cnt++;
		}
		
		System.out.println(cnt);
		
		
	}
	
	static int findMaxIdx(int[]arr) {
		int idx=0;
		int max = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]>=max) {
				max = arr[i];
				idx = i;
			}
		}
		
		return idx;
	}

}
