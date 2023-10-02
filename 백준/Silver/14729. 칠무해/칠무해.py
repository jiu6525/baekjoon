n = int(input())
l = []
for i in range(n):
    l.append(float(input()))

l.sort()
for i in range(7):
    print((f'{l[i]:.3f}'))