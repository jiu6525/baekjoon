n = int(input())
lst = list(map(int,input().split()))
ans = float("inf")
lst.sort()
for i in range(len(lst)//2):
    ans = min(ans,lst[i]+lst[len(lst)-1-i])
print(ans)