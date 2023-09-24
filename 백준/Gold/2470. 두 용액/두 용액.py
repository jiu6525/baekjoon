import sys
input = sys.stdin.readline
n = int(input())
l = list(map(int,input().split()))
l.sort()
s = 0
e = len(l) - 1
r = 10**10

while s < e:
    x = l[s] + l[e]
    if abs(x) < r:
        r = abs(x)
        sa,aa = l[s], l[e]
    if x < 0:
        s += 1
    else:
        e -= 1
print(sa,aa)
