s = set([])
for i in range(int(input())):
    a,b = input().split()
    if b == "enter":
        s.add(a)
    else:
        s.remove(a)

s = sorted(s,reverse=True)
for i in s:
    print(i)