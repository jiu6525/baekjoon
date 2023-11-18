n,m = map(int,input().split())
location = [0 for i in range(m+1)]
rg = [[] for i in range(m+1)]
for i in range(n):
    a,b,c = map(int,input().split())
    location[a] = 1
    rg[a].extend([b,c])

t = 0
idx = 1
while 1:
    t += 1
    if location[idx] == 1:
        r,g = rg[idx]
        if t % (r+g) <= r and t%(r+g)!=0:
            continue
        else:
            idx += 1
    else:
        idx += 1
    if idx == m:
        break
print(t)