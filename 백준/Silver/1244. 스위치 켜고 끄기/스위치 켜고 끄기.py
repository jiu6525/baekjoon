n = int(input())
lst = list(map(int,input().split()))
m = int(input())
for i in range(m):
    a,b = map(int,input().split())
    if a == 1:
        for i1 in range(b-1,n,b):
            lst[i1] = (lst[i1]+1)%2
    else:
        x,y = b-1,b-1
        while 1:
            dx = x-1
            dy = y+1
            if dx<0 or dy>=n:
                break
            if lst[dx] == lst[dy]:
                x,y = dx,dy
            else:
                break
        for i2 in range(x,y+1):
            lst[i2] = (lst[i2] + 1)%2

for i in range(1,n+1):
    print(lst[i-1],end=" ")
    if i%20==0:
        print()
