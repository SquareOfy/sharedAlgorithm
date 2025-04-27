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
			sb.append("#").append(tc).append(" ").append(treeCalculate(1)).append("\n");
			
		}
		System.out.println(sb.toString());
		
	}
	
	public static int treeCalculate(int node) {
		if(tree[node].left == 0) {
			return Integer.parseInt(tree[node].value);
			
		}else {
			int left = treeCalculate(tree[node].left);
			int right = treeCalculate(tree[node].right);
			
			return calculate(left, right, tree[node].value.charAt(0));
		}
	}
	
	static int calculate(int a, int b, char c) {
		if(c==operator[0]) {
			return a+b;
		}else if(c==operator[1]) {
			return a-b;
		}else if(c==operator[2]) {
			return a*b;
		}else {
			return a/b;
		}
	}
}