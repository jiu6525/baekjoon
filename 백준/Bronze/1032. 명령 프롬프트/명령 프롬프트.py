n = int(input())
l = []
for i in range(n):
    l.append(list(input()))

l.sort()
ans = l[0]
for i in range(1,len(l)):
    for j in range(len(l[i])):
        if l[i][j] != ans[j]:
            ans[j] = "?"

print("".join(ans))