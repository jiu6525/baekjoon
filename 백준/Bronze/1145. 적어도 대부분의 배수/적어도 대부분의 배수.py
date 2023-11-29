arr = list(map(int, input().split()))

num = min(arr)
cnt = 0
while True:
    cnt = 0
    for i in range(len(arr)):
        if num % arr[i] == 0 :
            cnt += 1
    if cnt >= 3:
        print(num)
        break
    num += 1