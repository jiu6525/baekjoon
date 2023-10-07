def prime_list():
    n,k = map(int,input().split())
    m = int(n*0.5)
    lst = [True] * (n+1)
    for i in range(2,m+1):
        if lst[i]:
            for j in range(i+i,n+1,i):
                lst[j] = False
    
    lst = [x for x in range(len(lst)) if lst[x] and x>1]
    l = []
    for i0 in lst:
        for i1 in range(i0,n+1,i0):
            if i1 not in l:
                l.append(i1)
    return l[k-1]

print(prime_list())