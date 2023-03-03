import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] numbers = new int[N];
		
		for(int n =0; n<N ; n++) {
			numbers[n] = sc.nextInt();
		}
		
		int gap = 0;
		int natural = 0;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			gap =0;
			for(int j=0; j<N; j++) {
				gap+= Math.abs(numbers[i] - numbers[j]);
			}
			if(gap < min) {
				min = gap;
				natural = numbers[i];
			}else if(gap ==min) {
				natural = Math.min(natural, numbers[i]);
			}
			
		}
	
		System.out.println(natural);

	}

}