def ck():
    r = []
    l = input()
    for i in l:
        if not r:
            r.append(i)
        else:
            if r[-1] == i:
                r.append(i)
            else:
                if i in r:
                    return 0
                else:
                    r.append(i)
    return 1

n = int(input())
ans = 0
for i in range(n):
    ans += ck()

print(ans)