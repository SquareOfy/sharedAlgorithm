import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] box = new int[N];
			int cnt =0;
			for(int i=0; i<N; i++) {
				box[i] = Integer.parseInt(br.readLine());
				if(box[i]>=50) {
					box[i]=0;
					cnt ++;
				}
			}
	
			Arrays.sort(box);
			int n = cnt; //옮긴 상자 수c
			int idx=N-1;
			int mIdx = cnt;
			while( idx>mIdx ) {
				if(box[idx]*(idx-mIdx +1)<50) {
					break;
				}
			
				n += 50 / box[idx]+1;
				cnt ++; //옮긴 횟수 증가
				mIdx += 50/box[idx]; 
                
				if(50%box[idx] ==0) { 
					//box[idx]가 50의 약수이면 몫만큼만 필요하므로 
					//위에서 n+= 50 / box[idx] +1 에서의 +1을 다시 빼줌.
					//mIdx도 다시 한칸만큼 back.
					n--;
					mIdx--;
				}
				idx --; //뒤에서 오는 인덱스 감소.

			}
			System.out.printf("#%d %d\n", t, cnt);
		}

	}

}
