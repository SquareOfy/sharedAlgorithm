import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] mushrooms = new int[10];
		for(int i=0; i<10; i++) {
			mushrooms[i] = Integer.parseInt(br.readLine());
		}
		
		int points = 0;
		for(int i=0; i<10; i++) {
			if(Math.abs(points - 100) >= Math.abs(points+mushrooms[i]-100)) {
				points += mushrooms[i];
			}else break;
		}
		
		System.out.println(points);
	}

}
