import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] kg = new int[N];
		int[] cm = new int[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			kg[i] = Integer.parseInt(st.nextToken());
			cm[i] = Integer.parseInt(st.nextToken());
		}
		int[] cnt = new int[N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(kg[i]<kg[j] && cm[i]<cm[j]) cnt[i]++;
				}
			System.out.print(cnt[i]+1+" ");
			}
		
		
		}
	}