a,b = map(str,input().split())
ans = 0
for i in a:
    for j in b:
        ans += int(i)*int(j)

print(ans)

