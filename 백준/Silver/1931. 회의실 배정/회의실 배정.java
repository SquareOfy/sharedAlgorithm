import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] meetings = new int[N][2];
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			meetings[n][0] = Integer.parseInt(st.nextToken());
			meetings[n][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(meetings, new Comparator<int[]>() {
			//끝나는 시간이 빠른 순으로 정렬. 끝나는 시간이 같을 경우 시작하는 시간이 빠른 순으로 정렬.
			@Override
			public int compare(int[] o1, int[] o2) {
				
				return o1[1]!=o2[1]? o1[1]-o2[1] : o1[0]-o2[0] ;
			}
			
		});
		
	

		int end =0;
		int cnt = 0;
		for(int n=0; n<N; n++) {
			if(meetings[n][0]>=end) {
				end = meetings[n][1];
				cnt ++;
			}
		
		}
		
		System.out.println(cnt);
		

	}


}