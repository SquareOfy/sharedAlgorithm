import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] melody = new int[8];
		for(int i =0; i<8; i++) {
			melody[i] = sc.nextInt();
		}
		boolean flag = false;
			for(int i=0; i<6; i++) {
				if((melody[i]-melody[i+1])* (melody[i+1]-melody[i+2])<0) {
					flag = true;
			}
		}
			if (flag) {
				System.out.println("mixed");
			}else if(!flag && melody[0]-melody[1]>0) {
				System.out.println("descending");
			}else System.out.println("ascending");
	}

}
