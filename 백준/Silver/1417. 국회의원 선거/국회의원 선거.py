n = int(input())
l = []

for i in range(n):
    l.append(int(input()))
dl = l[0]
lst = l[1:]
lst.sort(reverse=True)
count = 0
while 1:
    if len(l)>1 and dl<=lst[0]:
        dl+=1
        lst[0] -=1
        count += 1
        lst.sort(reverse=True)
    else:
        break
print(count)