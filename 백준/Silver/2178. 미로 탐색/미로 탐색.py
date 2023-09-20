from collections import deque

n,m = map(int,input().split())
arr = []
for i in range(n):
    arr.append(list(map(int,input())))

def bfs(a,b):
    q = deque([(a,b)])
    while q:
        x,y = q.popleft()
        for i,j in ((-1,0),(1,0),(0,1),(0,-1)):
            dx = x + i
            dy = y + j
            if dx<0 or dy<0 or dx>=n or dy>=m:
                continue
            if arr[dx][dy] == 0 or arr[dx][dy] != 1:
                continue
            else:
                arr[dx][dy] = arr[x][y] + 1
                q.append([dx,dy])

    return arr[n-1][m-1]


print(bfs(0,0))