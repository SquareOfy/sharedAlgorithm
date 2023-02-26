import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			String result = "YES";
			Stack<Character> stack = new Stack<>();
			String str = br.readLine();
			
			for(int i=0; i<str.length(); i++) {
				char p = str.charAt(i);
				if(p=='(') {
					stack.push(p);
				}else {
					if(!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					}else {
						result = "NO";
						break;
					}
				}
			}
			
			if(stack.size()!=0) {
				result = "NO";
			}
			
			System.out.println(result);
			
		}

	}

}
