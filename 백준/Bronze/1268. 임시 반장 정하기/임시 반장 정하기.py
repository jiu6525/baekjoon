n = int(input())
lst = []
arr = [0] * n
for i in range(n):
    lst.append(list(map(int,input().split())))
    arr[i] = [0] * n

for i in range(5):
    for j in range(n):
        for k in range(j+1, n):
            if lst[j][i] == lst[k][i]:
                arr[k][j] = 1
                arr[j][k] = 1

cnt = []
for i in arr:
    cnt.append(i.count(1))

print(cnt.index(max(cnt)) + 1)