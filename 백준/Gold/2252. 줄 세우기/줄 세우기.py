from collections import deque
n,m = map(int,input().split())
student = [[] for i in range(n+1)]
degree = [0 for i in range(n+1)]
que = deque()
for i in range(m):
    x,y = map(int,input().split())
    student[x].append(y)
    degree[y] += 1

for i in range(1,n+1):
    if degree[i] == 0:
        que.append(i)

while que:
    node = que.popleft()
    print(node,end=" ")
    for s in student[node]:
        degree[s] -= 1
        if degree[s] == 0:
            que.append(s)