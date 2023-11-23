for i0 in range(int(input())):
    lst = list(map(int,input().split()))
    n = lst[0]/2
    lst = lst[1:]
    d = {}
    for i in lst:
        if i not in d:
            d[i] = 1
        else:
            d[i] += 1

    max_key = max(d,key=d.get)
    print(max_key if n<d[max_key] else "SYJKGW")