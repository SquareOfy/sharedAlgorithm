import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			int result = 0;
			int cnt =1;
			int idx = 0;
			int[] buffer = {1,2,4};
			while(cnt<=N) {
				if(cnt ==1 ) {
					result = 1;
				}else if(cnt==2) {
					result = 2;
				}else if(cnt==3) {
					result = 4;
				}else {
					result =0;
					for(int i=0; i<3; i++) {
						result += buffer[i];
					}

					buffer[idx] = result;
					idx = (idx+1)%3;

				}
				cnt ++;
				
			}
			
			System.out.println(result);
			
			
	
	}

	}

}
