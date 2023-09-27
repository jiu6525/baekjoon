def fibo(n,d):
    if n==2:
        return d[2]
    if n==1:
        return d[1]

    if d[n]:
        return d[n]
    
    d[n] = fibo(n-2,d) + fibo(n-1,d)
    return d[n]



def ck():
    n,k = map(int,input().split())
    d = [0]*(31)
    for i in range(1, 100000):
        for j in range(i, 100000):
            d[1],d[2] = i,j
            fibo(n,d)
            if d[n] == k:
                return [i,j]
            d = [0]*(31)
            
answer = ck()
for i in answer:
    print(i)
