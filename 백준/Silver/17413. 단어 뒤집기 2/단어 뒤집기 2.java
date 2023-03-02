import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		String str = br.readLine();
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '<') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(str.charAt(i));
				i++;
				while(str.charAt(i)!='>') {
					sb.append(str.charAt(i));
					i++;
				}
				sb.append(str.charAt(i));//">"까지 출력할 수 도록 append.
			}else if(str.charAt(i)!=' ') {
				stack.push(str.charAt(i));
			}
			if(str.charAt(i) == ' '|| i==str.length()-1) {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				if(str.charAt(i)==' ')
				sb.append(str.charAt(i));
		
		}
		}
		
		System.out.println(sb.toString());
			
	

	}

}