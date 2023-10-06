lst = []
for i in range(int(input())):
    k = int(input())
    if k:
        lst.append(k)
    else:
        lst.pop()
print(sum(lst))