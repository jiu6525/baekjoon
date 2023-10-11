n = int(input())
d = [0] * (n+2)
d[1] = 1
d[2] = 1
def fibo(n):
    if n == 1:
        return 1
    if n == 0:
        return 0
    if d[n]:
        return d[n]
    d[n] = fibo(n-2)+fibo(n-1)
    return d[n]

print(fibo(n-1),fibo(n))