from collections import deque

def bfs(graph, k, visited):
    global cnt
    cnt += 1
    q = deque([k])
    visited[k] = True
    while q:
        x = q.popleft()
        for i in graph[x]:
            if not visited[i]:
                q.append(i)
                visited[i] = True

n,m = map(int,input().split())
arr = [[] for i in range(n+1)]

for i0 in range(m):
    u,v = map(int,input().split())
    arr[u].append(v)
    arr[v].append(u)

visited = [False] *(n+1)

cnt = 0
for i in range(1,n+1):
    if visited[i] == False:
        bfs(arr,i,visited)

print(cnt)
