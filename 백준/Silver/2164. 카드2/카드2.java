
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Queue<Integer> card = new LinkedList<>();
		
		for(int i=1; i<=N; i++ ) {
			card.add(i);
		}
		int n= 1;
		while(card.size() >1) {		
			card.poll();
			n++;
			card.add(card.poll());
			n++;
		}
		System.out.println(card.poll());
	}

}
