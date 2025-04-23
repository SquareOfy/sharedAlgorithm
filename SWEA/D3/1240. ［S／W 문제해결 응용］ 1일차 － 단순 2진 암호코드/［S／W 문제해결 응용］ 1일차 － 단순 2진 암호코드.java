import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution{
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		String[] nums = {"0001101", "0011001", "0010011","0111101","0100011","0110001","0101111","0111011","0110111","0001011"};
		HashMap<String, Integer> decodeMap = new HashMap<String, Integer>();
		for(int i=0; i<10; i++) {
			decodeMap.put(nums[i], i);
		}
		
		int T = sc.nextInt();
		for(int tc =1; tc<=T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			String[] codes = new String[N];
			for(int i=0; i<N; i++) {
				codes[i] = sc.next();
			}
			
			
			int[] decode = new int[8];
			int decodeIdx = 7;
			int odd = 0;
			int even = 0;
			
			for(int i=0; i<N; i++) {
				if(!codes[i].contains("1")) continue;
				int lastIdx = -1;
				for(int j=M-1; j>=0; j--) {
					if(codes[i].charAt(j)=='1') {
						lastIdx = j+1;
						break;
					}
				}
				
				while(decodeIdx!=-1) {
					decode[decodeIdx] = decodeMap.get(codes[i].substring(lastIdx-7, lastIdx));
					if(decodeIdx%2==0) {
						odd+=decode[decodeIdx];
					}else {
						even+=decode[decodeIdx];
					}
					decodeIdx--;
					lastIdx-=7;
				}
				break;
			}
			
			sb.append("#").append(tc).append(" ");
			if((odd*3+even)%10==0) {
				sb.append(odd+even);
			}else {
				sb.append(0);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}

}