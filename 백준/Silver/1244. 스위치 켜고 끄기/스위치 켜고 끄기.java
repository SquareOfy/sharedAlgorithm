import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    int T = Integer.parseInt(br.readLine());
	    int[] switchArr = new int[T];
	    st = new StringTokenizer(br.readLine());
	    for(int i=0; i<T; i++) {
	        switchArr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    int N = Integer.parseInt(br.readLine());
	    for(int i=0; i<N; i++) {
	        st = new StringTokenizer(br.readLine());
	        int s = Integer.parseInt(st.nextToken());
	        int num = Integer.parseInt(st.nextToken());

	        if(s==1) {
	            int idx = num-1;
	            while(idx < T) {
	                switchArr[idx] = (switchArr[idx]+1)%2;
	                idx = idx+num;
	            }
	        }else {
	            int k = 1;
	            outer : while(num-1+k<T && num-1-k>=0 ) {
	            	if(switchArr[num-1+k] == switchArr[num-1-k]) {
	                    k++;
	             
	                }else {
	                    break outer;
	                }
	            }
	            for(int j=-k+1; j<k; j++) {
	                switchArr[num-1+j] = (switchArr[num-1+j]+1)%2;
	            }
	        }
	    
	            
	    }
	    
	    for(int t=0; t<T; t++) {
	        System.out.print(switchArr[t]+" ");
	        if(t==T-1 || t%20 ==19) {
	            System.out.println();
	        }
	    }
	}
}