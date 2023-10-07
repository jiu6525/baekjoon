n,m = map(int,input().split())
arr = []
for i1 in range(n):
    arr.append(list(map(int,input().split())))

k = int(input())
for i1 in range(k):
    i,j,x,y = map(int,input().split())
    ans = 0
    for a in range(i,x+1):
        for b in range(j,y+1):
            ans += arr[a-1][b-1]

    print(ans)