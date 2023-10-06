from collections import deque

ans = [] 
l = deque()
n = int(input())
for i in range(n):
    a = input()
    if len(a.split()) == 2:
        a,b = a.split()
    if a == "push_front":
        l.appendleft(b)
    elif a == "push_back":
        l.append(b)
    elif a == "pop_front":
        if l:
            ans.append(l.popleft())
        else:
            ans.append(-1)
    elif a == "pop_back":
        if l:
            ans.append(l.pop())
        else:
            ans.append(-1)
    elif a == "size":
        ans.append(len(l))
    elif a == "empty":
        ans.append(0 if l else 1)
    elif a == "front":
        if l:            
            ans.append(l[0])
        else:
            ans.append(-1)
    else:
        if l:
            ans.append(l[-1])
        else:
            ans.append(-1)


for i in ans:
    print(i)