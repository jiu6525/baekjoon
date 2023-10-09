l = sorted(list(map(int,input().split())))
print(l[0]+l[1]+min(l[2],l[0]+l[1]-1))