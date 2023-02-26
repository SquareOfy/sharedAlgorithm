
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] line = new int[K];
		
		//랜선 길이 값을 배열에 받기 + 랜선 길이 중 최댓값 구하기
		int max =0;
		for (int i = 0; i < K; i++) {
			line[i] = Integer.parseInt(br.readLine());
			if(line[i]>max) {
				max = line[i];
			}
		}
		
		long start = 1;
		long end = max;
		long result = 0;
		while(start<=end) {
			long middle = (start + end)/2;
			long cnt = 0;
			
			for (int i = 0; i < K; i++) {
				cnt += line[i]/middle;
			}
			
			if(cnt<N) {
				end = middle -1;
			}else if(cnt>=N) {
				start = middle+1;
				result = middle;
			}
		
		}
		System.out.println(result);

	}

}