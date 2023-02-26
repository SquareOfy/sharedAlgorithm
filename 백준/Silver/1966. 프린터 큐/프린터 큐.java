import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			Queue<Print> printList = new LinkedList<>();
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] cntArr = new int[10];

			for (int i = 0; i < N; i++) {
				int priority = sc.nextInt();
				cntArr[priority]++;
				Print p = new Print(i, priority);
				printList.add(p);
			}

			int pointer = findpt(cntArr, 9);
			int cnt = 0;
			while (!printList.isEmpty()) {
				if (printList.peek().priority < pointer) {
					printList.add(printList.poll());

				} else {
					if (printList.peek().idx == M) {
						cnt++;
						break;
					} else {
						printList.poll();
						cnt++;
						cntArr[pointer]--;
						pointer = findpt(cntArr, pointer);

					}
			
				}
			}
			System.out.println(cnt);

		}
	}

	public static int findpt(int[] cntArr, int p) {
		if (p == 0) {
			return 0;
		}
		while (cntArr[p] == 0) {
			p--;
			if(p==0) {
				break;
			}
		}
		return p;
	}
}

class Print {
	int idx;
	int priority;

	public Print(int idx, int priority) {
		this.idx = idx;
		this.priority = priority;
	}
}
