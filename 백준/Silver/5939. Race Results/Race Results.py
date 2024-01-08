n = int(input())
ans = []
for i in range(n):
    ans.append(list(map(int,input().split())))
ans.sort()
for i in range(n):
    print(" ".join(list(map(str, ans[i]))))
    