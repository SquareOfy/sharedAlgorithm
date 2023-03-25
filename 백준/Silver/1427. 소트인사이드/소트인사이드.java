import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] arr;
	static boolean[] flag;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String nums = br.readLine();
		
		N = nums.length();
		arr = new int[N];
		flag = new boolean[N];
		
		for(int t=0; t<N; t++) {
			arr[t] = nums.charAt(t)-'0';
		}
		lomuto(arr, 0, N-1);
		for(int t=0; t<N; t++) {
			sb.append(arr[t]);
		}
		
		System.out.println(sb.toString());


	}
	
	public static void lomuto(int[] arr, int left, int right) {
		int pivot = arr[right];
		int i = left -1;
		int finish =0; 
		for(int j=left; j<right; j++) {
			if(arr[j]>=pivot) {
				i ++;
				swap(i, j);
			}
		}
		swap(i+1, right);
		flag[i+1] = true;
		for(int k=0; k<N; k++) {
			if(flag[k]) finish++;
			
		}
		if(finish == N) return;
		finish = 0;
		
		if(i>left) lomuto(arr, left, i);
		if(i+1<=right-2) lomuto(arr, i+2, right);
		
	}
	
	public static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}