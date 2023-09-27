from collections import deque
for i0 in range(int(input())):
    n,m = map(int,input().split())
    l = list(map(int,input().split()))
    lst = [[j,i] for i,j in enumerate(l)]
    q = deque(lst)
    count = 0
    while q:
        mq = max(q)
        x = q.popleft()
        if x[0] == mq[0]:
            count += 1
            if x[1] == m:
                break
        else:
            q.append(x)
    print(count)