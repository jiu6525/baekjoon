n = int(input())
arr = [3,5]

d = [10001] * (5001)

d[0] = 0
for i in range(len(arr)):
    for j in range(arr[i], n+1):
        if d[j - arr[i]] != 10001:
            d[j] = min(d[j], d[j -arr[i]] + 1)

if d[n] == 10001:
    print(-1)
else:
    print(d[n])