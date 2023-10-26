n,m = map(int,input().split())
lst = [int(input()) for i in range(n)]
lst.sort()
s = len(lst)-1
ans = 2e9
while s > -1:
    for i in range(s,len(lst)):
        r = lst[i] - lst[s]
        if r >= m:
            ans = min(ans,r)    
            break
    s -= 1

print(ans)