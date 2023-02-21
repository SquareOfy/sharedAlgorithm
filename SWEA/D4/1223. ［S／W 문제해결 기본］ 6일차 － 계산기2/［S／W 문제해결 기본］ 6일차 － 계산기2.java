import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		Stack<Integer> num = new Stack<>();
		Stack<Character> operator = new Stack<>();
		
		
		for(int t=1; t<=10; t++) {
		
		
			sb = new StringBuilder();
			int len = Integer.parseInt(br.readLine());
			String str = br.readLine();
			
			for(int i=0; i<len; i++) {
				if(str.charAt(i)=='+' ) {
					while(operator.size()!=0) {
						sb.append(operator.pop());
					}
					operator.push(str.charAt(i));
					
					
					
				}else if(str.charAt(i) =='*') {
					if(operator.isEmpty() || operator.peek()=='+') {
						operator.push(str.charAt(i));
					}else {
						sb.append(operator.pop());
						operator.push(str.charAt(i));
	
					}
					
					
						
				}else {
					sb.append(str.charAt(i));
				}
				
				if(i==len-1) {
					while(!(operator.isEmpty())) {
						sb.append(operator.pop());
					}
				}
			
				
			} //postfix만들기 끝.
			
			String postfix = sb.toString();
			for(int i=0; i<postfix.length(); i++) {
				if(postfix.charAt(i)=='*') {
					int n = num.pop();
					int m = num.pop();
					num.push(m*n);
			}else if(postfix.charAt(i)=='+') {
				int n = num.pop();
				int m = num.pop();
				num.push(m+n);
			}else {
				num.push((int)(postfix.charAt(i)-'0'));
				
			}
				
			
		}
		
			System.out.println("#"+t+" "+num.pop());
			operator.clear();
			num.clear();
			}
		
	}

}
