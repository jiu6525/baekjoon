from math import gcd
from itertools import combinations as combi

for i0 in range(int(input())):
    lst = list(map(int,input().split()))[1:]
    ans = 0
    for i in combi(lst,2):
        x,y = i
        ans += gcd(x,y)
    print(ans)
