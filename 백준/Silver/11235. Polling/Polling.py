d = {}
for i in range(int(input())):
    r = input()
    d[r] = 1 if r not in d else  d[r] + 1

d = sorted(d.items(), key=lambda x:-x[1])
maxd = d[0][1]

ans = [i for i,j in d if j == maxd]
for i in sorted(ans):
    print(i)