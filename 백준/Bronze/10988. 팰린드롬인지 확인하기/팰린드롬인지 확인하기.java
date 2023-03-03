import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		char[] reverse =  new char[str.length()];
		
		int result = 1;
		for(int i=0; i<str.length()/2; i++) {
			reverse[i] = str.charAt(str.length()-1-i);
			if(str.charAt(i)!=reverse[i]) {
				result = 0;
				break;
			}
		}
		System.out.println(result);

	}

}