n = int(input())
arr = []
for i in range(n):
    arr.append(list(map(int,input().split())))
arr = sorted(arr, key=lambda x:x[0])
s,e = arr[0][0], arr[0][1]
ans = e-s
for i in range(1,len(arr)):
    x,y = arr[i][0],arr[i][1]
    if x<=e:
        if y > e:
            s = e
            e = y
            ans += e-s
    else:
        s = x
        e = y
        ans += e-s

print(ans)