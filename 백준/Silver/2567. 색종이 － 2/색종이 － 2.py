
# 4방향 탐색
# x-1,y
# x,y-1
# x,y+1
# x+1,y
def check(x,y):
    cnt = 0
    for i,j in ((x-1,y),(x,y-1),(x,y+1),(x+1,y)):
        if arr[i][j] == 1:
            cnt += 1
    if cnt == 3:
        return 1
    elif cnt == 2:
        return 2
    return 0       

arr = [[0]*101 for i in range(101)]
lst = []
for i0 in range(int(input())):
    x,y = map(int,input().split())
    lst.append([x,y])
    for i in range(y,y+10):
        for j in range(x,x+10):
            arr[i][j] = 1
    
lst = sum(lst,[])
value = max(lst)+11
ans = 0
for i in range(value):
    for j in range(value):
        if arr[i][j] == 1:
            ans += check(i,j)

print(ans)