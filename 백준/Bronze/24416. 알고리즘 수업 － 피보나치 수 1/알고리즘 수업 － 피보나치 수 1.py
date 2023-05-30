def fib(n):
    global code1
    if (n == 1 or n == 2):
        code1 += 1
        return 1  # 코드1
    else:
        return (fib(n - 1) + fib(n - 2))

def fibonacci(n):
    global code2
    if f[1] <= f[2] <= 1:
        for i in range(3,n+1):
            f[i] = f[i - 1] + f[i - 2];  # 코드2
            code2 += 1
    return f[n]

code1, code2 = 0, 0
n = int(input())
f = [0,1,1]+[0]*n
fib(n),fibonacci(n)
print(code1, code2)