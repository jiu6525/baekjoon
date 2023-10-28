lst = []
n = int(input())
ans = 0
for i in range(n):
    lst.append(sorted(list(input())))

ck = []
for i in range(n):
    if lst[i] not in ck:
        ck.append(lst[i])

print(len(ck))