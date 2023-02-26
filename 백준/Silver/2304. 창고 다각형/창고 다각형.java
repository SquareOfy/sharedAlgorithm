import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] height = new int[1001];
		int last = 0;
		int max = 0;
		int maxIdx =0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			height[L] = H;
			if(last<L) last = L;
			if(max<H) {
				max = H; maxIdx = L;
			}
			
		}

		int temp = 0;
		int cnt = 0;
		for(int i=0; i<last+1; i++) {
			if(i>maxIdx) {
				stack.add(height[i]);
			}else {
				if(temp <=height[i]) {
					temp=height[i];
				}
				stack.add(temp);
			}
			
			
			}
		
		int area = 0;
		temp =0;
		for(int i=0; i<last+1; i++) {
			if(i<last+1-maxIdx) {
				if(temp <= stack.peek()) {
					temp = stack.pop();
				
				}else {
					stack.pop();
				}
				area+= temp;
				
			}else {
				area+= stack.pop();
			}
		
		}
		System.out.println(area);
	}
}
