j = list(map(int,input().split()))
s = list(map(int,input().split()))
ck = False
sumj = sums = 0
for i in range(9):
    if j[i]:
        sumj += j[i]
    if s[i]:
        if sumj > sums:
            if sums + s[i] > sumj:
                ck = True
        sums += s[i]

if sumj >= sums:
    ck = False

print("Yes" if ck else "No")