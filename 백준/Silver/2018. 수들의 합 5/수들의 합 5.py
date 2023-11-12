n = int(input())
ans = 0
for i in range(1,n+1):
    cnt = i
    for j in range(i+1,n+2):
        if cnt == n:
            ans += 1
            break
        if cnt>n:
            break
        cnt += j

print(ans)