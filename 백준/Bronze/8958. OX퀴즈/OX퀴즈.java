
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String testcase = br.readLine();
		int T = Integer.parseInt(testcase);
		
		for(int t=0; t<T; t++) {
			int cnt =0;
			int score =0;
			String[] arr = br.readLine().split("");
			int n = arr.length;
			for(int i=0; i<n; i++) {
				if(arr[i].equals("O")){
					cnt++;
					score += cnt;
				}else {
					cnt = 0;
				}
			}
			System.out.println(score);
			
		}
	
		
		

	}

}
