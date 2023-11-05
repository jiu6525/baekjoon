lst = sorted([list(map(int,input().split())) for i in range(int(input()))], key=lambda x:-x[2])
ck = []
ans = []
for i  in lst:
    if len(ck) == 3:
        break
    if ck.count(i[0]) == 2:
        continue
    else:
        ans.append([i[0],i[1]])
        ck.append(i[0])

for i in ans:
    print(f'{i[0]} {i[1]}')
