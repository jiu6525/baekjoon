def dfs(graph, v, visited):
    global answer
    visited[v] = True
    answer.append(v)
    for i in graph[v]:
        if not visited[i]:
            dfs(graph,i,visited)

    return len(answer)-1

n = int(input())
m = int(input())
arr = []
for i in range(m):
    arr.append(list(map(int,input().split())))

arr1 = [[] for i in range(n+1)]

for i,j in arr:
    arr1[i].append(j)
    arr1[j].append(i)

visited = [False] * (n+1)
answer = []


print(dfs(arr1,1,visited))
