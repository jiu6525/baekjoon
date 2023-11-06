import sys
sys.setrecursionlimit(10000)
def dfs(x,y):
    global count
    if x<=-1 or x>=m or y<=-1 or y>=n:
        return False
    if arr[x][y] == 0:
        arr[x][y] = 1
        count += 1
        dfs(x-1,y)
        dfs(x,y-1)
        dfs(x+1,y)
        dfs(x,y+1)
        return True
    return False


n,m,k = map(int,input().split())
arr = [[0]*n for i in range(m)]
for x in range(k):
    a,b,c,d = map(int,input().split())
    for i in range(a,c):
        for j in range(b,d):
            arr[i][j] = 1

result = []
for i in range(m):
    for j in range(n):
        count = 0
        if dfs(i,j) == True:
            result.append(count)

print(len(result))
print(" ".join(map(str, sorted(result))))

