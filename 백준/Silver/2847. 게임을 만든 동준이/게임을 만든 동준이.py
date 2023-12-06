n = int(input())
lst = [int(input()) for i in range(n)][::-1]
# 5,7,3,5
ans = []
ck = 0
cnt = 0
for i in range(n):
    if not ans:
        ans.append(lst[i])
        ck = lst[i]
    else:
        if lst[i]>=ck:
            r = ck - 1
            cnt += lst[i]-r
            ans.append(r)
            ck = r
        else:
            ans.append(lst[i])
            ck = lst[i]

print(cnt)