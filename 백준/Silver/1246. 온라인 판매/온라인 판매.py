n, m = map(int, input().split())
p = sorted([int(input()) for _ in range(m)])
ans = money = 0 
for i in range(m):
    egg = min(m - i, n) 
    if ans < p[i] * egg:
        ans = p[i] * egg 
        money = p[i] 

print(money, ans)