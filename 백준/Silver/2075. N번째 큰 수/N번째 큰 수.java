import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		int N = sc.nextInt();
		sc.nextLine();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(sc.nextLine());
			for(int j=0; j<N; j++) {
				int next = Integer.parseInt(st.nextToken());
				if(pq.size()<N) {
					pq.add(next);
				}else {
					pq.add(Math.max(pq.poll(), next));
				}
			}
		}
		
		System.out.println(pq.poll());
	}
}