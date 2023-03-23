import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		String[] byMinus = str.split("-");
		
		int result = 0;
		for(int i=0; i<byMinus.length; i++) {
			String[] add = byMinus[i].split("\\+");
			int temp = 0;
			for(int j=0; j<add.length; j++) {
				temp += Integer.parseInt(add[j]);
			}
			
			if(i==0) result += temp;
			else result -= temp;
		}
		
		System.out.println(result);
		
	}
}