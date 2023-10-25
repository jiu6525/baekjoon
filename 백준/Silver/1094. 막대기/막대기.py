lst = [64,32,16,8,4,2,1]
n = int(input())
ck,ans = 0,0
for i in lst:
    if n>=ck+i:
        ck += i
        ans += 1
print(ans)