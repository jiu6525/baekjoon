lst = []
n = int(input())
for i in range(n):
    lst.append(int(input()))
lst = lst[::-1]
count = 1
r = lst[0]
for i in range(1,len(lst)):
    if lst[i] > r:
        count += 1
        r = lst[i]

print(count)
