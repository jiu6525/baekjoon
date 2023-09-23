
def dfs(a,b):
    if a<0 or b<0 or a>=h or b>=w:
        return False
    if arr[a][b]:
        arr[a][b] = 0

        dfs(a-1,b)
        dfs(a+1,b)
        dfs(a,b-1)
        dfs(a,b+1)
        dfs(a-1,b-1)
        dfs(a-1,b+1)
        dfs(a+1,b-1)
        dfs(a+1,b+1)
        return True
    return False
while 1:
    w,h = map(int,input().split())
    if w != 0 and h !=0:
        arr = []
        for i in range(h):
            arr.append(list(map(int,input().split())))

        result = 0
        for i in range(h):
            for j in range(w):
                if arr[i][j]:
                    dfs(i,j)
                    result += 1

        print(result)
    else:
        break