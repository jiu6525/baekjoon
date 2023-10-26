p,n = map(int,input().split())
lst = list(map(int,input().split()))
ans = 0
lst.sort()
for i in range(n):
    if p<200:
        p += lst[i]
        ans += 1
    else:
        break

print(ans)