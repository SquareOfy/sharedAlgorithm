import java.util.Scanner;


class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=10; tc++) {
			int N = sc.nextInt();
			
			int[][] arr = new int[100][100];
			for(int r=0; r<100; r++) {
				for(int c=0; c<100; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			int answer = 0;
			boolean red = false;
			for(int c=0; c<100; c++) {
				red = false;
				
				for(int r=0; r<100; r++) {
					if(arr[r][c] == 1) red = true;
					else if(arr[r][c]==2) {
						if(red) {
							answer++;
							red = false;
						}
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
	
		
	
}
