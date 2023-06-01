l = []
for i in range(4):
    a,b = map(int,input().split())
    l.append([a,b])

r = l[0][1]
r1 = r-l[1][0]+l[1][1]
r2 = r1-l[2][0]+l[2][1]
print(max(r1,r2))