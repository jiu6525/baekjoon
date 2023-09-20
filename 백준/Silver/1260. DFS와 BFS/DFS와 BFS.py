from collections import deque

def dfs(graph, v, dfs_visited):
    global dfs_ans

    dfs_visited[v] = True
    dfs_ans.append(v)
    for i in graph[v]:
        if not dfs_visited[i]:
            dfs(graph,i,dfs_visited)

def bfs(graph, v, bfs_visited):
    global bfs_ans

    queue = deque([v])
    bfs_visited[v] = True

    while queue:
        x = queue.popleft()
        bfs_ans.append(x)
        for i in graph[x]:
            if not bfs_visited[i]:
                queue.append(i)
                bfs_visited[i] = True


n,m,k = map(int,input().split())

arr = []
for i in range(m):
    arr.append(list(map(int,input().split())))

arr1 = [[] for i in range(n+1)]
for i,j in arr:
    arr1[i].append(j)
    arr1[j].append(i)

for i in arr1:
    i.sort()

dfs_visited = [False] * (n+1)
bfs_visited = [False] * (n+1)
dfs_ans = []
bfs_ans = []
dfs(arr1, k, dfs_visited)
bfs(arr1, k, bfs_visited)


print(" ".join(map(str,dfs_ans)))
print(" ".join(map(str,bfs_ans)))