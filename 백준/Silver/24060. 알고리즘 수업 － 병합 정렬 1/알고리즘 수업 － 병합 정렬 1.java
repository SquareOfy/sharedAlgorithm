import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr;
	static int[] result;
	static int N;
	static int cnt;
	static int K;
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		result = new int[N];
		cnt =0;
		answer = -1;
		
		st = new StringTokenizer(br.readLine());
		for(int t=0; t<N; t++) {
			arr[t] = Integer.parseInt(st.nextToken());
		}
		sort(arr, 0, N-1);
		
		
		System.out.println(answer);


	}
	public static void sort(int[]arr, int left, int right) {
		if(left>=right) return;
		
		sort(arr, left, (left+right)/2);
		sort(arr, (left+right)/2+1, right);
		merge(arr, left, right);
		
	}
	
	
	public static void merge(int[] arr, int left, int right) {
		int m = (left+right)/2 ;
		int i = left;
		int j = m+1;
		int idx = left;
		while(i<=m && j<=right) {
			if(arr[i]<=arr[j]) {
				result[idx++] = arr[i];
				cnt ++;
				i++;
			}else {
				result[idx++] = arr[j];
				j++;
				cnt++;
			}
		if(cnt ==K) {
			answer = result[idx-1];
			break;
		}

			
		}
		if(cnt!= K) {
		for(int k=i; k<m+1; k++) {
			result[idx++] = arr[k];
			cnt ++;
			if(cnt ==K) {
				answer = result[idx-1];
				break;
			}
		}
		
		for(int k=j; k<=right; k++) {
			result[idx++] = arr[k];
			cnt++;
			if(cnt ==K) {
				answer = result[idx-1];
				break;
			}
		}
		
		for(int k=left; k<=right; k++) {
			arr[k] = result[k];
		}
		
		}
	}
}