n,m = map(int,input().split())
arr = []

for i in range(n):
    arr.append(list(input()))

for i in range(n):
    c = 0
    for j in range(m):
        if not c and arr[i][j] == 'c':
            arr[i][j] = c
            c += 1
            continue
        elif arr[i][j] == 'c':
            c = 0
            arr[i][j] = c
            c += 1
            continue

        if c:
            arr[i][j] = c
            c += 1
        else:
            arr[i][j] = -1

for i in arr:
    print(" ".join(map(str,i)))

