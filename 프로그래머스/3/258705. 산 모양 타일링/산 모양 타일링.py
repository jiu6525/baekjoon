from typing import List

# 2차원 dp 선언
# dp[n][1] - 오른쪽 마름모로 끝날때
# - dp[n-1][0] -> 왼쪽 마름모 이거나 삼각형으로 끝날대 -> 오른쪽 마름모로 끝나지 않는 경우의 수 +
# - dp[n-1][1] -> 오른쪽 마름모로 끝나는 수
# dp[n][1] = dp[n-1][0] + dp[n-1][1]
# dp[n][0]  -> 마름모, 삼각형, 즉 dp[n][1]이 아닌 모든 경우
# - dp[n-1][0] * 2 + dp[n-1][1]


# dp[n][0]  -> 마름모, 삼각형, 즉 dp[n][1]이 아닌 모든 경우
# dp[n][1] -> 오른쪽 마름모로 끝나는 경우

# dp[0][0] = 2 -> 왼쪽 마름모 이거나 삼각형으로 채워지는 경우
# dp[0][1] = 1 -> 오른쪽 마름모로 끝나는 경우

def solution(n, tops):
    answer = 0
    dp: List[List[int]] = [[0, 0] for i in range(n)]
    MOD = 10007
    
    if tops[0] == 1:
        dp[0][0] = 3
        dp[0][1] = 1
    else:
        dp[0][0] = 2
        dp[0][1] = 1
    
    for i in range(1, n):
        if tops[i] == 1:
            dp[i][0] = dp[i-1][0] * 3 + dp[i-1][1] * 2
        else:
            dp[i][0] = dp[i-1][0] * 2 + dp[i-1][1]
        dp[i][1] = dp[i-1][0] + dp[i-1][1]
        
        dp[i][0] %= MOD
        dp[i][1] %= MOD
        
    answer = (dp[n-1][0] + dp[n-1][1]) % MOD
    return answer