
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
				new Comparator<Integer>() {
					public int compare(Integer o1, Integer o2) {
						int abs1 = Math.abs(o1);
						int abs2 = Math.abs(o2);
						if (abs1==abs2) {
							return o1-o2;
						}
						return abs1-abs2;
					}
		});
		
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();
			if (x!=0) {
				pq.add(x);
			}else {
				if (pq.isEmpty()) {
					sb.append(0);
				}else {
					sb.append(pq.poll());
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}
