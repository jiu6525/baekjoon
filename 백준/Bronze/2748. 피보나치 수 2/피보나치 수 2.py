n = int(input())
d = [0] * 91

def fibo(n):
    if n == 1 or n == 2:
        return 1
    if d[n]:
        return d[n]
    
    d[n] = fibo(n-2) + fibo(n-1)
    return d[n]

print(fibo(n))