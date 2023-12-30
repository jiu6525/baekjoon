n=int(input())
for i in range(n):
    num=int(input())
    cal=10
    while num>cal:
        if num%cal>=cal/2:
            num=((num//cal)+1)*cal
        else:
            num=(num//cal)*cal
        cal*=10
    print(num)
