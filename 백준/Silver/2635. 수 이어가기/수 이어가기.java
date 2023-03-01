import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list;
		
		int N = sc.nextInt();
		
		int next = N/2+1;
		int num = 0;
		int max = 0;
		while(next <= N) {
			list = new ArrayList<>();
			list.add(N);
			list.add(next);
			while(list.get(list.size()-1)>=0) {
				list.add(list.get(list.size()-2)-list.get(list.size()-1));
			}
			if(list.size()-1 > max) {
				max = list.size()-1;
				num = next;
			}
			next = next +1;
			
		}
		list = new ArrayList<>();
		list.add(N);
		list.add(num);
		
		while(list.get(list.size()-1)>=0) {
			list.add(list.get(list.size()-2)-list.get(list.size()-1));
		}
		
		
		System.out.println(max);
		for(int i =0; i<max; i++) {
			System.out.print(list.get(i)+ " ");
	
		}
			
	}

}