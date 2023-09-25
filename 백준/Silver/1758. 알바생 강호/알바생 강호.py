n = int(input())
l = []
for i in range(n):
    l.append(int(input()))
    
l.sort(reverse=True)
answer = 0
for i,j in enumerate(l):
    x = j-i
    if x<0:
        continue
    else:
        answer += x

print(answer)