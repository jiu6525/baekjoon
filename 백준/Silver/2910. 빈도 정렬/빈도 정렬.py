n,m = map(int,input().split())
a = list(map(int,input().split()))
x = {}
for i in a:
    if i not in x:
        x[i] = 1
    else:
        x[i] +=1

x = sorted(x.items(), key=lambda x:-x[1])
for i,j in x:
    for z in range(j):
        print(i,end=" ")