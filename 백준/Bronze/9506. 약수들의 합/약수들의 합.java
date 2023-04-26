import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			List<Integer> list = new ArrayList<Integer>();
			int N = sc.nextInt();
			if(N==-1) break;
			for(int i=1; i<N; i++) {
				if(N%i ==0) list.add(i);
			}
			int sum =0;
			for(int j=0; j<list.size(); j++) {
				sum+= list.get(j);
			}
			
			if(sum==N) {
				sb.append(N+" = ");
				for(int j=0; j<list.size(); j++) {
					if(j==list.size()-1) sb.append(list.get(j)).append("\n");
					else sb.append(list.get(j)).append(" + ");
					
				}
			}else {
				sb.append(N).append(" is NOT perfect.").append("\n");
			}
		}
		System.out.println(sb.toString());

	}

}
