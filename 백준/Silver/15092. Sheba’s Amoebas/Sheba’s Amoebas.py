def dfs(x,y):
    if x<0 or y<0 or x>=n or y>=m:
        return 0
    if lst[x][y] == "#":
        lst[x][y] = "."

        dfs(x,y+1)
        dfs(x,y-1)
        dfs(x-1,y)
        dfs(x+1,y)
        dfs(x-1,y-1)
        dfs(x-1,y+1)
        dfs(x+1,y+1)
        dfs(x+1,y-1)

        return 1
    return 0

n,m = map(int,input().split())
lst = []
for i in range(n):
    lst.append(list(input()))

result = 0
for i in range(n):
    for j in range(m):
        if lst[i][j] == "#":
            if dfs(i,j):
                result += 1

print(result)