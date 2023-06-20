
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] input = new String[N];
		int[] alphabet = new int[26];
		
		for(int n=0; n<N; n++) {
			input[n] = br.readLine();
			int len = input[n].length();
			for(int i=0; i<len; i++) {
				alphabet[input[n].charAt(i)-65] += Math.pow(10, len-i-1);
			}
		}
		
		
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(( o1, o2)-> {
			return o2[1]-o1[1];
		});
		for(int i=0; i<26; i++) {
			pq.add(new int[] {i, alphabet[i]});
		}
	
		
		int cnt =9;
		while(!pq.isEmpty()) {
			int[] value = pq.poll();
			if(value[1]!=0) {
			alphabet[value[0]]=cnt;
			cnt--;
			}
		}
		

		int result = 0;
		for(int n=0; n<N; n++) {
			String str = input[n];
			int len = str.length();
			for(int i=0; i<len; i++) {
				result+= alphabet[str.charAt(i)-65]*Math.pow(10, len-i-1);
			}
		}
		
		
		System.out.println(result);
	}
	
	

	

}
