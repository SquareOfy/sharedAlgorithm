import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


class Solution {
	
	static HashMap<String, Integer> map;
	static String[] word = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
	
	static class Node implements Comparable<Node>{
		String text;
		int num;
		
		Node(String text){
			this.text = text;
			this.num = map.get(text);
		}

		@Override
		public int compareTo(Solution.Node o) {
			return this.num - o.num;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		map = new HashMap<>();
		for(int i=0; i<10; i++) {
			map.put(word[i], i);
		}
		
		for(int tc = 1; tc<=T; tc++) {
			String test = sc.next();
			int N = sc.nextInt();
			Node[] arr = new Node[N];
			for(int i =0; i<N; i++) {
				arr[i] = new Node(sc.next());
			}
			
			Arrays.sort(arr);
			sb.append(test).append("\n");
			for(int i=0; i<N; i++) {
				sb.append(arr[i].text).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
			
		
	}
	

	
}
