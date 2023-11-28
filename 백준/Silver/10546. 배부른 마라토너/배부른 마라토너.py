n = int(input())
lst = []
for i in range(n*2-1):
    lst.append(input())

d = {}
for i in lst:
    if i not in d:
        d[i] = 1
    else:
        d[i] += 1

for x,y in d.items():
    if y%2 != 0:
        print(x)
        break