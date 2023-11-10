n = int(input())
lst = list(map(int,input().split()))
lst.sort()
ans = []
for i in set(lst):
    cnt = 0
    for j in range(len(lst)):
        cnt += abs(i-lst[j])
    ans.append([cnt,i])
ans.sort(key=lambda x:(x[0],x[1]))
print(ans[0][1])
