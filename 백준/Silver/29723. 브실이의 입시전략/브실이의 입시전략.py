n,m,k = map(int,input().split())
d = {}
ans = 0
for i in range(n):
    a,b = input().split()
    d[a] = int(b)

for i in range(k):
    c = input()
    ans += d[c]
    del d[c]
dx = sorted(d.values())
dy = sorted(dx, reverse=True)
mina,maxa = ans,ans
for i in range(m-k):
    mina += dx[i]
    maxa += dx[-1-i]

print(mina,maxa)
