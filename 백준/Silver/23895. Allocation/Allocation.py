for i in range(int(input())):
    n,m = map(int,input().split())
    lst = sorted(list(map(int,input().split())))
    ck = 0
    ans = 0
    for j in lst:
        if ck+j <= m:
            ck += j
            ans += 1
        else:
            break
    print(f'Case #{i+1}: {ans}')
