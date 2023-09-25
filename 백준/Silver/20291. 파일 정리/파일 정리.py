n = int(input())
arr = {}
for i in range(n):
    x = input().split(".")[1]
    if x not in arr:
        arr[x] = 1
    else:
        arr[x] += 1

arr = sorted(arr.items() , key=lambda x:x[0])

for i,j in arr:
    print(i,j)