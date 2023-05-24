def ck():
    if n == -1:
        return False
    r = []
    for i in range(1,n):
        if n%i==0:
            r.append(i)
    
    return r

while 1:
    n = int(input())
    a = ck()
    if not a:
        break
    
    if sum(a) == n:
        res = list(map(str,a))
        ans = f'{n} = ' + res[0]
        for i in range(1,len(res)):
            ans += ' + ' + res[i]
        print(ans)
    else:
        print(f'{n} is NOT perfect.')