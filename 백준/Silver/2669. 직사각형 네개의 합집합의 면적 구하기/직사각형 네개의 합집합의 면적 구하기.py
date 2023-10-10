lst = []
for i in range(4):
    lst.append(list(map(int,input().split())))
m = max(map(max,lst))
arr = [[0]*(m+1) for i in range(m+1)]
for x1,x2,y1,y2 in lst:
    for i in range(x1,y1):
        for j in range(x2,y2):
            arr[i][j] = 1
ans = 0
for i in arr:
    ans += i.count(1)

print(ans)