import sys
input = sys.stdin.readline

n,m = map(int,input().split())
add = {}

for i in range(n):
    si, ps = input().split()
    add[si] = ps 

for j in range(m):
    print(add[input().rstrip()])
