n = int(input())
r = ""
for i in range(1,n+1):
    r += str(i)

for i in range(len(r)):
    if int(r[i:i+len(str(n))]) == n:
        print(i+1)
        break
