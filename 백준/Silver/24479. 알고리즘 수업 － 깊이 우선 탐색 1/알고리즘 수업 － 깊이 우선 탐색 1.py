import sys
sys.setrecursionlimit(10 ** 5)

n,m,k = map(int,input().split())
arr = [[] for i in range(n+1)]
for i in range(m):
    a,b = map(int,input().split())
    arr[a].append(b)
    arr[b].append(a)

for i in arr:
    i.sort()
visited = [0] * (n+1)
count = 0
def dfs(graph,v,visited):
    global count
    count += 1
    visited[v] = count
    for i in graph[v]:
        if not visited[i]:
            dfs(graph,i,visited)

dfs(arr,k,visited)

for i in range(1,len(visited)):
    print(visited[i])