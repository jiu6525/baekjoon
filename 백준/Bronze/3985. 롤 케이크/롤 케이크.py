L = int(input())
N = int(input())
cake = [0 for i in range(L+1)]
many_c, rmany_c = 0,0
c,rc = 0,0
people = []
for i in range(N):
    x,y = map(int,input().split())
    people.append([x,y])
    pic = y-x
    if pic > many_c:
        c = i + 1
        many_c = pic

for j in range(N):
    x,y = people[j]
    for j1 in range(x,y+1):
        if cake[j1] == 0:
            cake[j1] += j + 1

for z in range(1,N+1):
    r = cake.count(z)
    if r > rmany_c:
        rc = z
        rmany_c = r

print(c,rc,sep="\n")
