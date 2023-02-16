import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String testcase = br.readLine();
		int T = Integer.parseInt(testcase);
		
		double mean =0;
	
		for(int t=1; t<=T; t++) {
			mean =0;
			int cnt = 0;
			String[] scores = br.readLine().split(" ");
			int N = Integer.parseInt(scores[0]);
			for(int i =1; i<=N; i++) {
				mean += Double.parseDouble(scores[i]);
			}
			mean /= N;
			
			for(int i=1; i<=N; i++) {
				if(Double.parseDouble(scores[i])>mean) {
					cnt += 1;
				}
			}
			double result = (((double)cnt/N)*100);
			System.out.printf("%.3f%% \n",result);
			
		}
	}

}
