import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		int lenX = 0;
		boolean flag = true;
		String answer = "";
		for(int i=0; i<str.length(); i++) {
			
			if(str.charAt(i)=='.' || i==str.length()-1){
				if(i==str.length()-1 && str.charAt(i)=='X') lenX ++;
				if(lenX % 2 ==1) {
					flag = false;
				
					break;
				}else {
					for(int j=0; j<lenX/4; j++) {
						answer += "AAAA";
					}
					for(int j=0; j<(lenX%4)/2; j++) {
						answer += "BB";
					}
					lenX = 0;
					if(str.charAt(i)=='.') answer += '.';
					
				}
			}else if(str.charAt(i)=='X') {
				lenX ++;
			}
		}
		
		if(flag) System.out.println(answer);
		else System.out.println(-1);

	}

}