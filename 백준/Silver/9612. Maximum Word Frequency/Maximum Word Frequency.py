words = [input() for i in range(int(input()))]
count = {}
lst = []

for i in words:
    if i not in count:
        count[i] = 1
    else:
        count[i] += 1

count = sorted(count.items(), key=lambda x:-x[1])
for i,j in count:
    if j == count[0][1]:
        lst.append([i,j])

print(*sorted(lst,reverse=True)[0])
