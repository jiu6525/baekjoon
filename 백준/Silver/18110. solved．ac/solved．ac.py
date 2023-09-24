def r(n):
    return int(n)+1 if n-int(n)>=0.5 else int(n)

n = int(input())
l = []
m = r(n*0.15)
for i in range(n):
    a = int(input())
    l.append(a)
l.sort()
lst = l[m:len(l)-m]
answer = 0 if not lst else r(sum(lst)/len(lst))
print(answer)