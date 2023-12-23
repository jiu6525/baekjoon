n = int(input())
arr = {}
count = 0
 
for i in range(n):
    a,b = map(int, input().split())
    if a not in arr:
        arr[a] = b
    else:
        if arr[a] != b:
            count +=1
            arr[a] = b
print(count)
