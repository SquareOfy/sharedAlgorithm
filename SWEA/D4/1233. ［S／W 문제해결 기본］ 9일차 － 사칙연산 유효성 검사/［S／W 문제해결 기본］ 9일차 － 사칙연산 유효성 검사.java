import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution{
	
	static Node[] tree;
	static char[] operator = {'+', '-', '*', '/'};
	static int N; 
	
	static class Node{
		String value;
		int left;
		int right;
		
		Node(String value, int left, int right){
			this.value = value;
			this.left = left;
			this.right = right;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "value : " + value +" \n";
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int tc=1; tc<=10; tc++) {
			N = sc.nextInt();
			sc.nextLine();
			tree = new Node[N+1];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(sc.nextLine());
				int num = Integer.parseInt(st.nextToken());
				String value = st.nextToken();
				int left = 0;
				int right = 0;
				if(st.hasMoreTokens()) left = Integer.parseInt(st.nextToken());
				if(st.hasMoreTokens()) right = Integer.parseInt(st.nextToken());
				
				
				tree[num] = new Node(value, left, right);
			}
			int answer = isPossible(1) ? 1 : 0;
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
			
		}
		System.out.println(sb.toString());
		
	}
	
	public static boolean isPossible(int node) {
		boolean isNumber = true;

		for(char c : operator) {
			if(tree[node].value.charAt(0) == c ) {
				isNumber = false;
				break;
			}
		}
		if(tree[node].left == 0) {
			if (isNumber) return true;
			else return false;
			
		}else {
			boolean leftPossible = isPossible(tree[node].left);
			if(!leftPossible || tree[node].right ==0 || isNumber) return false;
			
			return isPossible(tree[node].right);
		}
	}
}