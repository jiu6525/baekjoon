from collections import deque
l = [ i for i in range(1,int(input())+1)]
q = deque(l)
r = []
while q:
    a = q.popleft()
    r.append(a)
    if q:
        b=q.popleft()
        q.append(b)
print(r[-1])