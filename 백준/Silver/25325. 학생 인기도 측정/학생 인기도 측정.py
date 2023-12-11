n = int(input())
student = input().split()
res = {i : 0 for i in student}

for i in range(n):
    a = list(input().split())
    for j in a:
        res[j] += 1

ans = sorted(res.items(), key=lambda x:x[1], reverse=True)

for k,v in ans:
    print(k,v)