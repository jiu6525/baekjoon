n = int(input())
dp = [0] * (n+1)
def f(n):
    if n == 1 or n == 2:
        return 1
    if dp[n]:
        return dp[n]
    
    dp[n] = f(n-2) + f(n-1)
    return dp[n]

print(f(n))

