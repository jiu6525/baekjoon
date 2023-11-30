import sys
sys.setrecursionlimit(100000)

def dfs(y, x):
    graph[y][x] = '.'
    for dy, dx in d:
        Y, X = y+dy, x+dx
        if (0 <= Y < H) and (0 <= X < W) and graph[Y][X] == '#':
            dfs(Y, X)

for _ in range(int(input())):
    H, W = map(int, input().split())
    graph = [list(input()) for _ in range(H)]
    d = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    cnt = 0
    for i in range(H):
        for j in range(W):
            if graph[i][j] == '#':
                dfs(i, j)
                cnt += 1
    print(cnt)