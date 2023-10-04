l = []
N = int(input())
for i in range(N):
    l.append(list(map(int,input().split())))

# print(l)
def dfs(n,sm):
    global ans
    if n>=N:
        ans = max(sm,ans)
        return
    if n+l[n][0] <=N:  
        dfs(n+l[n][0],sm+l[n][1])
    dfs(n+1,sm)

ans = 0
# for i in range(len(l)):
dfs(0,0)


print(ans)