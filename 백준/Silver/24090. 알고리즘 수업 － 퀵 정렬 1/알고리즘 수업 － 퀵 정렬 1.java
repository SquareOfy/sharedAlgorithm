import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static int[] arr;
	static int cnt;
	static boolean flag;
	static String answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		cnt = 0;
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		sort(0, N - 1);
		if (!flag) {
			System.out.println(-1);
		}else {
			System.out.println(answer);
		}

	}
	
	public static void sort(int left, int right) {
		if(left<right) {
			int q = partition(left, right);
			sort(left, q-1);
			sort(q+1, right);
		}
	}
	public static int partition(int left, int right) {
		int pivot = arr[right];
		int i = left - 1; // pivot보다 작거나 같은 원소들의 끝지점을 가리킬 포인터
		for (int j = left; j < right; j++) {
			if (arr[j] <= pivot) {
				i++;
				swap(i, j);

			}
		}
		if (i + 1 != right) {
			swap(i+1, right);
		}
		return i + 1;

	}

	public static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		cnt++;
		if (cnt == K) {
			if (arr[i] <= arr[j]) {
				answer = String.valueOf(arr[i]) + " " + String.valueOf(arr[j]);
			} else {
				answer = String.valueOf(arr[j]) + " " + String.valueOf(arr[i]);
			}
			flag = true;

		}
	}
}