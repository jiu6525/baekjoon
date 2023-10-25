a,b = map(int,input().split())
lst = []
for i in range(int(input())):
    lst.append(int(input()))
ck1 = abs(b-a)
ck2 = 1001
for i in lst:
    ck2 = min(ck2,abs(b-i))
ck2 = 1+ck2
print(min(ck1,ck2))