n = int(input())
l = []
for i in range(n):
    a,b = map(int,input().split())
    l.append([a,b])
l.sort()
t = 0
for i,j in l:
    if t<i:
        while t<i:
            t += 1
    t+=j

print(t)