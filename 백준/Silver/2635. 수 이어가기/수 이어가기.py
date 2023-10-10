ans = []
n = int(input())
for i in range(n,0,-1):
    q = [n,i]
    while 1:
        r = q[-2] - q[-1]
        if r < 0:
            break
        q.append(r)
    if len(q)>len(ans):
        ans = q

print(len(ans))
print(" ".join(map(str,ans)))