import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//밑면의 반대쪽 면에 해당되는 index를 추출하기 위한 배열
		int[] idx = { 5, 3, 4, 1, 2, 0 };
		
		
		int N = Integer.parseInt(br.readLine());
		//주사위 입력받을 배열
		int[][] dice = new int[N][6];

		
		//주사위 입력 받기
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 6; i++) {
				dice[n][i] = Integer.parseInt(st.nextToken());

			}
		}

		int max = 0;
		// 첫번째 주사위의 0번부터 5번까지 인덱스를 돌면서 윗면이라고 생각하고 그걸 기준으로 나머지 주사위를 그 윗면과 맞춰가며 side 중 최댓값을 찾아 나갈것.
		for (int i = 0; i < 6; i++) {
			//첫번째 주사위의 사이드 중 최댓값을 찾아보자.
			int sideSum = 0;
			int maxSide = 0;
			int num = dice[0][i]; // 첫 주사위의 윗면 숫자.
			// 첫 주사위 숫자를 전체 돌면서 옆면 숫자인 것만 비교해서 제일 큰 값 찾기
			for (int j = 0; j < 6; j++) {
				//i는 윗면의 index , idx[i]는 아랫면의 index, 얘네 빼면 옆면이므로
				//maxSide보다 보고 있는 옆면의 숫자가 더 크면, maxSide로 놓기
				if (j != i && j != idx[i]) {
					if (maxSide < dice[0][j]) {
						maxSide = dice[0][j];
					}
				}

			}
			//첫번째 주사위가 i번째일 때, 첫번째 주사위 옆면 중 제일 큰 값 더하기 
			sideSum += maxSide;

			// 남은 주사위를 돌면서 옆면 체크, 단 주사위가 1개일 때를 대비해서 if문 넣은 것.
			if (N != 1) {
				for (int k = 1; k < N; k++) {
					//주사위 마다 maxSide 0으로 초기화
					maxSide = 0;
					//윗면의 index를 기억해둘 변수(j for문이 종료 돼도 찾아야하니까!)
					int topIdx = 0;
					
					//이전 주사위의 윗면인 index를 찾고 그 index를 topIdx로 놓기
					//그런 후, num은 그 주사위의 반대편 숫자를 기억(다음 주사위의 아랫면이 되어야할 숫자)
					for (int j = 0; j < 6; j++) {
						if (dice[k][j] == num) {
							//윗면, 아랫면 알아내기 위한 인덱스 기억
							topIdx = j;
							//윗면 숫자를 반대편 숫자로 기억하기
							num = dice[k][idx[topIdx]];
							
							break;
						}
					}
					
					//k번째 주사위의 모든 숫자를 돌면서 밑면, 윗면이 아닌 index를 비교하며 maxSide 대입하기.
					for (int j = 0; j < 6; j++) {
						if (j != topIdx && j != idx[topIdx]) {
							if (maxSide < dice[k][j]) {
								maxSide = dice[k][j];
							}
						}

					}
					//위에서 구한 k번째 주사위 옆면의 최댓값을 sideSum에 더하기.
					sideSum += maxSide;
				}

			}
			//i for문(1번째 주사위의 6개 숫자 중 뭐가 윗면이 될까 탐색하는 for문)의 마지막 과정 ,,
			//sideSum 중의 최댓값 구하기.
			if (max < sideSum)
				max = sideSum;
			
	
			

		}
	
		System.out.println(max);

	}

}