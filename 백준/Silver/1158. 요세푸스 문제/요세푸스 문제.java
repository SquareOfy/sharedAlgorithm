import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<Integer>();
		List<Integer> answerList = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			queue.add(i);
		}
		
		int cnt = 0;
	
		while(!queue.isEmpty()) {
			cnt ++;
			int now = queue.poll();
			if(cnt==K) {
				cnt = 0;
				answerList.add(now);
				continue;
			}
			queue.add(now);
		}
		
		sb.append("<");
		for(int i=0; i<N; i++) {
			sb.append(answerList.get(i));
			if(i!=N-1) {
				sb.append(", ");
			}
		}
		sb.append(">");
		System.out.println(sb.toString());
	}

}
