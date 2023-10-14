n,m = map(int,input().split())
lst = list(map(int,input().split()))

c = 0
for i in range(len(lst)):
    s = 0
    for j in range(i,len(lst)):
        s += lst[j]
        if s == m:
            c += 1
            break

print(c)