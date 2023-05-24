n = int(input())
result = []
for i in range(n):
    l = input()
    result.append(l[0]+l[-1])

for i in result:
    print(i)