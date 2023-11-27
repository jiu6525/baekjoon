def dfs(v):
    visited[v] = 1
    node = lst[v]
    if visited[node] == 0:
        dfs(node)
        return

for i0 in range(int(input())):
    n = int(input())
    a = [i for i in range(1,n+1)]
    lst = [0] + list(map(int,input().split()))
    visited = [0] + [0 for i in range(1,n+1)]
    cnt = 0
    for i in range(1,n+1):
        if visited[i] == 0:
            dfs(i)
            cnt += 1
    print(cnt)