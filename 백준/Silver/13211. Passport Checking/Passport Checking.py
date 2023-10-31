n = int(input())
hs = set()
for _ in range(n):
    hs.add(input())

m = int(input())
cnt = 0
for _ in range(m):
    if input() in hs:
        cnt += 1

print(cnt)