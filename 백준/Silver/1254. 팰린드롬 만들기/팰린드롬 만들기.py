p = input()
idx = 0
for i in range(len(p)):
    if p[i:] == p[i:][::-1]:
        idx = i
        break

q = p[::-1][len(p)-idx:]

for i in q:
    if p[::-1] == p:
        break
    else:
        p += i
print(len(p))