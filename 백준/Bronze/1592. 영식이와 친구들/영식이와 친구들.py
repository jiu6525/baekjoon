i,c = 0,0
n,m,l = map(int,input().split())
lst = [1] + [0 for i in range(n-1)]
while lst[i] !=m:
    if lst[i]%2 !=0:
        i = (i+l)%n
        lst[i] += 1
    else:
        i = (i-l)%n
        lst[i] += 1
    c += 1

print(c)
