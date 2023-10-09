n,m = map(int,input().split())
# n,m = 3,7
lst = []
for i in range(1,m+1):
    for j in range(i):
        lst.append(i)

print(sum(lst[n-1:m]))