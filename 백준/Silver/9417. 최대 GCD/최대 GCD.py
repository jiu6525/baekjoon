from math import gcd

for i0 in range(int(input())):
    lst = list(map(int,input().split()))
    ans = 0
    for i in range(len(lst)):
        for j in range(i+1,len(lst)):
            ans = max(ans,gcd(lst[i],lst[j]))

    print(ans)