import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(br.readLine());

		
		List<Integer> cutH = new ArrayList<Integer>();
		List<Integer> cutW = new ArrayList<Integer>();
		cutH.add(0);
		cutW.add(0);
		
		
		int maxW = 0;
		int maxH = 0;
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			
			int direction = Integer.parseInt(st.nextToken());
		
			//가로로 자를 때 세로 max 결정하기
			if(direction == 0) {
				cutH.add(Integer.parseInt(st.nextToken()));	
				
				
			//세로로 자를 때 가로 max 결정하기
			}else {
				cutW.add(Integer.parseInt(st.nextToken()));

			}
		}
			

			cutW.sort(Comparator.naturalOrder());
			cutH.sort(Comparator.naturalOrder());
			
		
			int temp =0;
			
			for(int i=0; i<cutW.size(); i++) {
				if(i!= cutW.size()-1 ) {
					temp = cutW.get(i+1)-cutW.get(i);
				}
				else if(i==cutW.size()-1) {
					temp = W - cutW.get(i);
				}
			
				if(maxW < temp) maxW = temp;
		
			}
			
			
			for(int i=0; i<cutH.size(); i++) {
				if(i!= cutH.size()-1 ) {
					temp = cutH.get(i+1)-cutH.get(i);
				}
				else if(i==cutH.size()-1) {
					temp = H - cutH.get(i);
				}
			
				if(maxH < temp) maxH = temp;
		
			}
		
			System.out.println(maxH * maxW);
		}

	

}