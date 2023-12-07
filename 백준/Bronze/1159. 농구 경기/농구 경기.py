n = int(input())
lst = []
result = []

for _ in range(n):
    a = input()
    lst.append(a[0])

d = set(lst)

for i in d:
    if lst.count(i) >= 5:
        result.append(i)

if len(result) > 0:
    print(''.join(sorted(result)))
else:
    print("PREDAJA")