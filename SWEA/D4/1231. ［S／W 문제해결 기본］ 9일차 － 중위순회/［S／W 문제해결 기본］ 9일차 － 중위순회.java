import java.util.Scanner;
import java.util.StringTokenizer;

class Solution {
	static char[] answer;
	static Node[] tree;
	
	static class Node{
		char value;
		int left;
		int right;
		
		Node(char value, int left, int right){
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int tc = 1; tc<=10; tc++) {
			int N = sc.nextInt();
			sc.nextLine();
			
			tree = new Node[N+1];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(sc.nextLine());
				
				int myNum = Integer.parseInt(st.nextToken());
				char myValue = st.nextToken().charAt(0);
				int left = -1;
				int right = -1;
				
				if(st.hasMoreTokens()) {
					left = Integer.parseInt(st.nextToken());
				}
				if(st.hasMoreTokens()) {
					right = Integer.parseInt(st.nextToken());
				}
				tree[myNum] = new Node(myValue, left, right);
			}
			answer = new char[N];
			sb.append("#").append(tc).append(" ");
			inorder(1, sb);
			sb.append("\n");
			
			
		}
		
		System.out.println(sb.toString());
	}
	
	static void inorder(int node, StringBuilder sb) {
		if(tree[node].left!=-1) {
			inorder(tree[node].left, sb);
		}
		sb.append(tree[node].value);
		if(tree[node].right!=-1) {
			inorder(tree[node].right, sb);
		}
	}
}
