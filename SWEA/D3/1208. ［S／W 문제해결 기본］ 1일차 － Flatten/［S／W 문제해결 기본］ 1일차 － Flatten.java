
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t=1; t<=10; t++) {
			int dump = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			int[] boxes = new int[100];
			int[] cntBox = new int[101];
			
			for(int i=0; i<100; i++) {
				boxes[i] = Integer.parseInt(st.nextToken());
				cntBox[boxes[i]]++;
			}
			int minIdx =1;
			int maxIdx = 100;
			for(int j=1; j<=dump; j++) {
				if(maxIdx-minIdx<=1) break;
				
				if(cntBox[minIdx] ==0) minIdx ++;
				if(cntBox[maxIdx] ==0) maxIdx --;
				if(cntBox[minIdx]!=0) {
					cntBox[minIdx]--;
					cntBox[minIdx+1]++;
					if(cntBox[minIdx]==0) minIdx++;
				}
				if(cntBox[maxIdx]!=0) {
					cntBox[maxIdx]--;
					cntBox[maxIdx-1]++;
					if(cntBox[maxIdx]==0) maxIdx--;
				}
				
			}
			System.out.printf("#%d %d \n", t,maxIdx - minIdx);
				
			
				
			
			
		}
		
	}

}
