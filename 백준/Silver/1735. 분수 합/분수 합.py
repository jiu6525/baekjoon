a1,b1 = map(int,input().split())
a2,b2 = map(int,input().split())

def ck(x,y):
    while y!= 0:
        x %= y
        x,y = y,x
    return x

x = a1*b2 + a2*b1
y = b1*b2
n = ck(x, y)
print((x)//n, y//n)