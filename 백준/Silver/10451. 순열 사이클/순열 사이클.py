from collections import deque
for i0 in range(int(input())):
    queue = deque()
    n = int(input())
    a = [i for i in range(1,n+1)]
    lst = list(map(int,input().split()))

    arr = [[] for i in range(n+1)]

    for i in range(n):
        arr[a[i]].append(lst[i])
        
    ans = 0
    for i in range(1,n+1):
        if arr[i]:
            q = arr[i].pop()
            queue.append(q)
            while queue:
                node = queue.popleft()
                if not arr[node]:
                    break
                else:
                    for j in arr[node]:
                        queue.append(j)
                    arr[node].pop()
            ans += 1

    print(ans)