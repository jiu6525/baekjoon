n = int(input())
lst = list(map(int,input().split()))
lst.sort()
ans, suml = 0, 0
while len(lst)>=2:
    a = lst.pop(0)
    b = lst.pop(0)
    suml = a+b
    lst.append(suml)
    lst.sort()
    ans += a*b

print(ans)