import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken()); int h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken()); int q = Integer.parseInt(st.nextToken());
	
		int t = Integer.parseInt(br.readLine());
		
		int resultx = w - Math.abs((p+t)%(2*w) - w);
		int resulty = h- Math.abs((q+t)%(2*h)-h);
		
		sb.append(resultx).append(" ").append(resulty);
		

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}