import sys
input = sys.stdin.readline
n = int(input())
lst = list(map(int,input().split()))
ans = [0 for i in range(n+1)]
for i in range(1,n+1):
    ans[i] = ans[i-1] + lst[i-1]

m = int(input())
for i in range(m):
    a,b = map(int,input().split())
    print(ans[b] - ans[a-1])
