def solution(n,a,b):
    count = 0
    idx = 1
    l = [i for i in range(1,n+1)]
    while idx<len(l):
        idx *= 2
        count += 1
        for i in range(0,len(l),idx):
            if (a in l[i:i+idx]) and (b in l[i:i+idx]):
                return count
