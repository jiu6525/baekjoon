l = []
for i in range(int(input())):
    l.append(list(map(int,input().split())))
r = 0
for i in range(len(l)):
    a,b,c = l[i]
    if a == b == c:
        ans = 10000 + a * 1000
    elif a != b and b != c and a != c:
        ans = max(a,b,c) * 100
    else:
        if l[i].count(a) == 2:
            ans = 1000 + a * 100
        else:
            ans = 1000 + b * 100
        
    r = max(r,ans)

print(r)