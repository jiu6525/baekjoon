lst = [i * (i + 1) // 2 for i in range(1, 46)]
ans = [0] * 1001

for i in lst:
    for j in lst:
        for k in lst:
            num = i + j + k
            if num <= 1000:
                ans[num] = 1

t = int(input())
for i in range(t):
    print(ans[int(input())])
 