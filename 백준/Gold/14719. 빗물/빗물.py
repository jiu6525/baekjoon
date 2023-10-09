n,m = map(int,input().split())
lst = list(map(int,input().split()))
ans = 0
for i in range(1,m-1):
    left = max(lst[:i])
    right = max(lst[i+1:])

    x = min(left,right)
    if lst[i] < x:
        ans += x-lst[i]

print(ans)