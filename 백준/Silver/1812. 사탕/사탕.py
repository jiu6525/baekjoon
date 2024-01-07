n = int(input())
lst = [int(input()) for i in range(n)]
s = sum(lst)//2
ck = 0
for i in range(1,len(lst),2):
    ck += lst[i]

ans = [s-ck]
for i in range(len(lst)-1):
    num = lst[i]-ans[i]
    ans.append(num)

for i in range(n):
    print(ans[i])
