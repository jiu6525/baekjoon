import sys
input = sys.stdin.readline
n,m = map(int,input().split())
l = list(map(int,input().split()))
l.sort()
for i in l:
    if i<= m:
        m+=1

print(m)