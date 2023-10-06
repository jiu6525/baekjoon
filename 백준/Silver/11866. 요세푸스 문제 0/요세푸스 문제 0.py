from collections import deque
n,k = map(int,input().split())
lst = [i for i in range(1,n+1)]
lst = deque(lst)

ans = []
while lst:
    for i in range(k-1):
        lst.append(lst.popleft())
    ans.append(str(lst.popleft()))

print("<"+", ".join(ans)+">")