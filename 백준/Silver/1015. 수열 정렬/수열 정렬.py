n = int(input())
a = list(map(int,input().split()))
x = sorted(a)
n = [i for i in range(len(a))]

r = []
for i,j in enumerate(x):
    r.append([i,j])

answer = []
for i in range(len(a)):
    for j in range(len(r)):
        if r[j][1] == a[i] and r[j][0] not in answer:
            answer.append(r[j][0])
            break
        
print(" ".join(map(str,answer)))