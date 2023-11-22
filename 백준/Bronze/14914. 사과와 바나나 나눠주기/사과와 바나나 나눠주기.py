from math import gcd
a,b = map(int,input().split())
for i in range(1, gcd(a,b)+1):
    if gcd(a,b) % i == 0:
        print(i, a//i, b//i)