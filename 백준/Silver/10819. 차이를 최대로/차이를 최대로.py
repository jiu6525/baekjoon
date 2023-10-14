from itertools import permutations as pm
n = int(input())
lst = list(map(int,input().split()))
ans = 0
for i0 in pm(lst):
    ck = 0
    for i in range(1,len(i0)):
        ck += abs(i0[i-1] - i0[i])
    ans = max(ans,ck)
print(ans)