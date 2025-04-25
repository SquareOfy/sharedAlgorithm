import java.util.HashMap;
import java.util.Scanner;


class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt();
			
			double[] point = new double[N];
			double[] weight = new double[N];
			
			for(int i=0; i<N; i++) {
				point[i] = sc.nextDouble();
			}
			
			for(int i=0; i<N; i++) {
				weight[i] = sc.nextDouble();
			}
			
			sb.append("#").append(tc).append(" ");
			for(int i=0; i<N-1; i++) {
				double left = point[i];
				double right = point[i+1];
				
				double mid = 0;
				double value = 0;
				
				while(left<right) {
					
					mid = (left+right)/2;
					value = 0;
					
					for(int j=0; j<N; j++) {
						if(point[j] < mid) {
							value+= weight[j]/((mid-point[j])*(mid-point[j]));
						}else {
							value -= weight[j]/((point[j]-mid)*(point[j]-mid));
						}
					}
					
					
					
					if(Math.abs(value) <= 1e-13) {
						break;
					}else if(value>0) {
						left = mid+1e-13;
					}else {
						right = mid-1e-13;
					}
					
				}
				
				sb.append(String.format("%.10f", mid)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
			
		
	}
	

	
}
