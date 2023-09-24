from collections import deque
n,m,k = map(int,input().split())
arr = [[] for i in range(n+1)]
for i in range(m):
    a,b = map(int,input().split())
    arr[a].append(b)
    arr[b].append(a)

for i in arr:
    i.sort()
    
visited = [0] *(n+1)
count = 1
def bfs(graph, v, visited):
    global count
    q = deque([v])
    visited[v] = count
    while q:
        x = q.popleft()
        for i in graph[x]:
            if not visited[i]:
                q.append(i)
                count += 1
                visited[i] = count

bfs(arr,k,visited)
for i in range(1,len(visited)):
    print(visited[i])