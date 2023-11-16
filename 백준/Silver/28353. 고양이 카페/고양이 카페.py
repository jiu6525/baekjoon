n,k = map(int,input().split())
lst = list(map(int,input().split()))
lst.sort()
ans = 0

s,e= 0, n-1

while s<e:
    if lst[s]+lst[e] <= k:
        s += 1
        e -= 1
        ans += 1
    else:
        e -= 1

print(ans)
    