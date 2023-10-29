lst = []
k = int(input())
ans,cnt = 0,0
for i in range(int(input())):
    lst.append(int(input()))
lst.sort()
for i in lst:
    if ans+i>k:
        break
    else:
        ans+=i
        cnt+=1
print(cnt)
