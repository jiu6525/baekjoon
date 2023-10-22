n,m = map(int,input().split())
ans = []
for i in range(n):
    l = input()
    for j in range(len(l)):
        if l[j].isdigit():
            ans.append([int(l[j]),j])
            break

ans = sorted(ans,key=lambda x:-x[1])
rank = 1
idx = ans[0][1]
for i in ans:
    if i[1] == idx:
        i[1] = rank
    else:
        idx = i[1]
        rank += 1
        i[1] = rank    

ans = sorted(ans,key=lambda x:x[0])
for i in ans:
    print(i[1])