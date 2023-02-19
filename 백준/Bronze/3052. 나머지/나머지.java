import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		int cnt = 0;
		int[] remainderArr = new int[42];
			for(int i =0; i<10; i++) {
				n =Integer.parseInt(br.readLine());
				remainderArr[n%42] += 1;
			}
			for(int i=0; i<42; i++) {
				if(remainderArr[i]>=1) {
					cnt ++;
				}
			}
			
			System.out.println(cnt);;
			
			

	}
	

}
