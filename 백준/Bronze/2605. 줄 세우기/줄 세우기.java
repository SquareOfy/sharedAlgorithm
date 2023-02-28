import java.awt.List;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> line = new LinkedList<>();
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			int n = sc.nextInt();
//			if(n==i) {
//				line.addFirst(i);
//			}else {
				line.add(i-n, i+1);
//			}
			
		}
		
		for(int i=0; i<line.size(); i++) {
			System.out.print(line.get(i)+" ");
		}

	}

}
