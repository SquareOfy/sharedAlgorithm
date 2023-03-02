import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			int N = Integer.parseInt(br.readLine());
			int[] heap = new int[N+1];
			int lastIdx = 0;
			for(int n=1; n<=N; n++) {
				st = new StringTokenizer(br.readLine());
				if(Integer.parseInt(st.nextToken())==1) {
					int k = Integer.parseInt(st.nextToken());
					heap[++lastIdx] = k;
					int point = lastIdx;
					
						while(point >1 && heap[point/2]<heap[point]) {
					
							heap[point]=heap[point/2];
							heap[point/2] = k;
							point = point/2;
				
						
						
					}
				}else {
					if(lastIdx ==1) {
						sb.append(heap[1]).append(" ");
						heap[lastIdx--] = 0;
					}
					else if(lastIdx > 0) {
						int temp = heap[lastIdx];
						heap[lastIdx--] = 0;
						sb.append(heap[1]).append(" ");
						heap[1] = temp;
						
						int point = 1;
						while(true) {
							int child = point *2;
						
							//오른쪽 자식이 있고 걔가 왼쪽 애보다 크다면
							if(child+1 <= lastIdx && heap[child]<heap[child+1]) {
								child++;
							}
							
							if(child > lastIdx || heap[child]<heap[point])
								break;

							heap[point] = heap[child];
							heap[child] = temp;
							
							point = child;
						
		
						}
					}
					else sb.append(-1).append(" ");
					
				}
				
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}