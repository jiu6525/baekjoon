def ck(lst):
    lst.sort()
    ans = 0
    for i in range(1,len(lst)):
        ans = max(ans,lst[i]-lst[i-1])
    return ans

n,m = map(int,input().split())
nl,ml = [0,n],[0,m]
k = int(input())
for i in range(k):
    a,b = map(int,input().split())
    if a:
        nl.append(b)
    else:
        ml.append(b)

print(ck(nl)*ck(ml))