a,b = map(int,input().split())
lst = [a]
while 1:
    a = str(a)
    l = 0
    for i in a:
        l += int(i)**b
    if l in lst:
        lst = lst[:lst.index(l)]
        break
    else:
        lst.append(l)
        a = l

print(len(lst))