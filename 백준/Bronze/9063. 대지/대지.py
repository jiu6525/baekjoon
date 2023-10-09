n = int(input())
xarr = []
yarr = []
for i in range(n):
    a,b = map(int,input().split())
    xarr.append(a)
    yarr.append(b)

print((max(xarr)-min(xarr))*(max(yarr)-min(yarr)))