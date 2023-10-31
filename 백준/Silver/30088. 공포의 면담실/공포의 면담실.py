lst = []
for i in range(int(input())):
    lst.append(sum(list(map(int,input().split()))[1:]))

lst.sort()
ans = 0
for i in range(1,len(lst)+1):
    ans += sum(lst[:i])

print(ans)