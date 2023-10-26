n,m = map(int,input().split())
lst = [int(input()) for i in range(n)]
lst.sort()
s,e = 0,0
ans = 2e9

while s <= e and e < n:
    if lst[e]-lst[s] < m:
        e += 1
    else:
        ans = min(ans, lst[e]-lst[s])
        s += 1

print(ans)