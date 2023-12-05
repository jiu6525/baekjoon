n,m = map(int,input().split())
arr1 = []
for i in range(n):
    arr1.append(list(map(int,input().split())))

m,k = map(int,input().split())
arr2 = []
for j in range(m):
    arr2.append(list(map(int,input().split())))

ans = [[0 for z in range(k)] for _ in range(n)]

for N in range(n):
    for K in range(k):
        for M in range(m):
            ans[N][K] += arr1[N][M] * arr2[M][K]

for i in ans:
    print(*i)