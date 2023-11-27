from collections import deque

def bfs(x, y):
    dx = [0,0,1,-1]
    dy = [-1,1,0,0]
    queue = deque()
    queue.append([x,y])
    lst[x][y] = 0
    w = 1
    while queue:
        a,b = queue.popleft()
        for i in range(4):
            nx = a + dx[i]
            ny = b + dy[i]

            if 0 <= nx < n and 0 <= ny < m and lst[nx][ny] == 1:
                w += 1
                lst[nx][ny] = 0
                queue.append([nx,ny])
    res.append(w)


n, m = map(int,input().split())
lst = []
res = [0]
cnt = 0
for i in range(n):
    lst.append(list(map(int,input().split())))
for i in range(n):
    for j in range(m):
        if lst[i][j]:
            bfs(i, j)
            cnt += 1
            
print(cnt)
print(max(res))