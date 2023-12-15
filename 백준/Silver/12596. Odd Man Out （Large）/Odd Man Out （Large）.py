for i0 in range(int(input())):
    n = int(input())
    lst = list(map(int,input().split()))
    d = {}
    for i in lst:
        if i not in d:
            d[i] = 1
        else:
            d[i] += 1
    
    for k,v in d.items():
        if v == 1:
            print(f'Case #{i0+1}: {k}')