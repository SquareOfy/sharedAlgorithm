import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Queue<Integer> List = new LinkedList<>();
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Integer> seq = new LinkedList<>();

		for(int n=1; n<=N; n++) {
			List.offer(n);
		}
		
		while(List.size()>1) {
			for(int i=0; i<K-1; i++) {
				int temp = List.poll();
				List.offer(temp);
				
			}
			seq.offer(List.poll());
		}
		seq.offer(List.poll());
		
		System.out.print("<");
		while(!seq.isEmpty()) {
			if(seq.size()>1) System.out.print(seq.poll()+", ");
			else System.out.print(seq.poll());
		}
		System.out.print(">");
		
		
	}
}
