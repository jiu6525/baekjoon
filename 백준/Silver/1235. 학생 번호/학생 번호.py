n = int(input())
lst = [input() for i in range(n)]
cnt = 1
while 1:
    if len({i[-cnt:] for i in lst}) == n:
        print(cnt)
        break
    cnt += 1
