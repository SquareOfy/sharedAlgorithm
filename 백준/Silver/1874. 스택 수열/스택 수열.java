import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] seq = new int[N];
		for(int i=0; i<N; i++ ) {
			seq[i] = Integer.parseInt(br.readLine());
		}
		boolean rFlag = true;
		for(int i=0; i<N; i++) {
			if(!checkSeq(seq, i)) rFlag = false;
			}
		
	
		if(!rFlag) {
			System.out.println("NO");
		}else {
			Stack<Integer> stack = new Stack<>();
			int n =1;
			for(int i=0; i<N; i++) {
				
				while((stack.isEmpty() || stack.peek()<seq[i] )&&n<N ) {
					stack.push(n++);
					sb.append("+\n");

				
				}
				
				while(!(stack.isEmpty())&&stack.peek()==seq[i] && n<=N) {
					
					stack.pop();
					sb.append("-\n");
					
				
				}
				
			
				if(seq[i]==N) {
					stack.push(seq[i]);
					sb.append("+\n");
					while(!stack.isEmpty()) {
						stack.pop();
						sb.append("-\n");
						
					}
				}
			}
			
			
			bw.write(sb.toString());
			bw.flush();
			bw.close();
		}
		
	}
			

	

	
	static boolean checkSeq(int[] seq, int i) {
		boolean flag = false;
		int term = 0;
		if(seq[i]==1) {
			return true;
		}
		else {
			for(int j = i+1; j<seq.length; j++) {
				if(seq[j]<seq[i] && flag == false) {
					flag = true;
					term = seq[j];
				}
				if(flag == true && seq[j]<seq[i]) {
					if(term<seq[j]) return false;
				}
			}
		}
		return true;
	}

}
