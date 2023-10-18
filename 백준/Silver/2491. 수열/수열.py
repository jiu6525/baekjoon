n = int(input())
lst = list(map(int,input().split()))
dp1 = [1]*n
dp2 = [1]*n

for i in range(n-1):
    if lst[i+1] >= lst[i]:
        dp1[i+1] += dp1[i]
    if lst[i+1] <= lst[i]:
        dp2[i+1] += dp2[i]

m1 = max(dp1)
m2 = max(dp2)
print(max(m1,m2))