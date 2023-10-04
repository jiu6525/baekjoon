def f(n,m):
    if m==1:
        return n
    return n*f(n,m-1)

for i in range(10):
    n = int(input())
    a,b = map(int,input().split())
    print(f'#{i+1} {f(a,b)}')