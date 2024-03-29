def dfs(a,b):
    if a<0 or b<0 or a>=n or b>=m:
        return False
    if arr[a][b] == 1:
        arr[a][b] = 0 

        dfs(a-1,b)
        dfs(a+1,b)
        dfs(a,b+1)
        dfs(a,b-1)

        return True
    return False

t = int(input())
answer = []
for i0 in range(t):
    n,m,k = map(int,input().split())
    arr = [[0 for _ in range(50)] for __ in range(50)]

    for i1 in range(k):
        x,y = map(int,input().split())
        arr[x][y] = 1

    result = 0
    for i in range(n):
        for j in range(m):
            if dfs(i,j):
                result += 1
    answer.append(result)

for i in answer:
    print(i)
