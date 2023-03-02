import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			
			
			int result = findPoint((findrc(p)[0] + findrc(q)[0]), findrc(p)[1]+findrc(q)[1]);
//		
			System.out.printf("#%d %d \n", t, result);

	}
	}
static int[] findrc(int p) {
	
	int i= 1;
	while(startP(i) <= p) {
		i++;
	}
	
	int a = 1;
	int b = i-1;
	
	while(findPoint(a,b) != p) {
		a++;
		b--;
	}
	int[] result = {a,b};
	return result;
}

static int findPoint(int a, int b) {

	
 return startP(a+b-1) + a-1;

}
	
	
	
	

static int startP(int i) {
	int result = 1;
	if(i ==1){
		return result;
	}else {
		int n =1;
		while(n<=i-1) {
			result += n++;
		}
	}
	return result;
}

}