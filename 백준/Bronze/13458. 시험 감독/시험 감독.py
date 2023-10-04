n = int(input())
l = list(map(int,input().split()))
B,C= map(int,input().split())

a,b=0,0
for i in range(len(l)):
    l[i] -= B 
    a += 1
    if l[i]<0:
        continue

    b += l[i]//C if l[i]%C == 0 else (l[i]//C)+1

print(a+b)