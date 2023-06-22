n = int(input())
for i in range(n):
    a,b = map(int,input().split())
    a1,b1 = a,b
    while b1 != 0:
        a1 = a1 % b1
        a1,b1 = b1,a1
    print(a*b//a1)