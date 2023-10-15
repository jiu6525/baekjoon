n,m = map(int,input().split())
lst = [[0 for i in range(100)] for j in range(100)]
for i in range(n):
    a,b,c,d = map(int,input().split())
    for x in range(a,c+1):
        for y in range(b,d+1):
            lst[x-1][y-1] += 1
ans = 0
for i in range(100):
    for j in range(100):
        if lst[i][j]>m:
            ans += 1

print(ans)