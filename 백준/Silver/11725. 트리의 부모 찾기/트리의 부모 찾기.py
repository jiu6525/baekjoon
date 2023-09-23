from collections import deque

n = int(input())
arr = [[] for i in range(n+1)]
for i in range(n-1):
    a,b = map(int,input().split())
    arr[a].append(b)
    arr[b].append(a)

q = deque()
q.append(1)

ans = [0] * (n+1)
def bfs():
    while q:
        x = q.popleft()
        for i in arr[x]:
            if not ans[i]:
                ans[i] = x
                q.append(i)

bfs()
for i in ans[2:]:
    print(i)