"""
dp배열을 miro 사이즈로 만들고 
dp배열에 각 자리마다 대각, 상, 좌 부분까지 왔을 때의 최댓값이 기록되어 있으므로
그 중 최댓값과 현재 자리의 miro 값을 더해서 dp값을 갱신한다.

인덱스가 범위를 넘어가는 것을 처리하기 위해 miro, dp 배열에 마진을 주어
n+2, m+2로 지정했다.
"""
n, m = map(int, input().split())
miro = [[0]*(m+2)]+[[0]+list(map(int, input().split()))+[0] for _ in range(n)]+[[0]*(m+2)]
dp = [[0]*(m+2) for i in range(n+2)]


for i in range(1, n+1):
    for j in range(1, m+1):
        dp[i][j] = max(max(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+miro[i][j]

print(dp[n][m])