while 1:
    try:
        n,k=map(int,input().split())
        t,r = 0,0
        while n>=k:
            t=n//k
            r+=k*t
            n=n%k+t
        r+=n
        print(r)
    except:
        break

