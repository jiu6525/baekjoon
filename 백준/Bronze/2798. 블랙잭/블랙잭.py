n, m = map(int,input().split())
l = list(map(int,input().split()))
ll = []
for i in range(0,len(l)):
    for i1 in range(i+1,len(l)):
        for i2 in range(i1+1,len(l)):
            result = l[i]+l[i1]+l[i2]
            if result <= m:
                ll.append(result)
print(max(ll))