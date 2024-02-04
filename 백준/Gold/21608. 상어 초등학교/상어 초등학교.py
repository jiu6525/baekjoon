good = {0:0,1:1,2:10,3:100,4:1000}
n = int(input())
d = [[0]*5]
arr = [[0]*(n+1) for i in range(n+1)]
for i in range(n**2):
    lst = list(map(int,input().split()))
    d.append(lst)
ans = 0
for i in range(1,len(d)):
    lst = d[i][1:]
    ck_lst = []
    for i0 in range(1,len(arr)):
        for i1 in range(1,len(arr)):
            ck,zck = 0,0
            if not arr[i0][i1]:
                for x,y in((-1,0),(1,0),(0,-1),(0,1)):
                    dx = x + i0
                    dy = y + i1
                    if dx<1 or dy<1 or dx>n or dy>n:
                        continue
                    else:
                        if arr[dx][dy] in lst:
                            ck += 1
                        elif not arr[dx][dy]:
                            zck += 1
                ck_lst.append([i0,i1,ck,zck])

                
    ck_lst.sort(key=lambda x: (-x[2],-x[3],x[0],x[1]))
    arr[ck_lst[0][0]][ck_lst[0][1]] = d[i][0]

d.sort(key=lambda x:x[0])

for i in range(1,len(arr)):
    for j in range(1,len(arr)):
        count = 0
        a = d[arr[i][j]][0]
        b = d[arr[i][j]][1:]
        for x,y in((-1,0),(1,0),(0,-1),(0,1)):
            dx = x + i
            dy = y + j
            if dx<1 or dy<1 or dx>n or dy>n:
                continue
            if arr[dx][dy] in b:
                count += 1
        ans += good[count]
print(ans)