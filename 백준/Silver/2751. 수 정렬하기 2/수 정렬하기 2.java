import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int[] arr;
	static int[] result;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		result = new int[N];
		
		for(int t=0; t<N; t++) {
			arr[t] = Integer.parseInt(br.readLine());
		}
		sort(arr, 0, N-1);
		for(int t=0; t<N; t++) {
			sb.append(arr[t]).append("\n");
		}
		
		System.out.println(sb.toString());


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
				i++;
			}else {
				result[idx++] = arr[j];
				j++;
			}
			
		}
		for(int k=i; k<m+1; k++) {
			result[idx++] = arr[k];
		}
		
		for(int k=j; k<=right; k++) {
			result[idx++] = arr[k];
		}
		
		for(int k=left; k<=right; k++) {
			arr[k] = result[k];
		}
	}
}