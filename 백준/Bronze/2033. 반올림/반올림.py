n = int(input())
d = 10
while n>d:
    if n%d >= d//2:
        n += d
    n -= (n%d)
    d *= 10
print(n)