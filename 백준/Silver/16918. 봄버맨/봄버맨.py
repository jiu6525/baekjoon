n,m,k = map(int,input().split())
arr = []
for i in range(n):
    arr.append(list(input()))

rearr = [['O'] * m for j in range(n)]
bomb1 = [['O'] * m for j in range(n)]
bomb2 = [['O'] * m for j in range(n)]

if k<=1:
    for i2 in arr:
        print("".join(i2))
elif k%2==0:
    for i in rearr:
        print("".join(i))
else:
    for i in range(n):
        for j in range(m):
            if arr[i][j] == 'O':
                bomb1[i][j] = '.'
                for x,y in ((1,0),(-1,0),(0,1),(0,-1)):
                    dx = i + x
                    dy = j + y
                    if dx<0 or dy<0 or dx>=n or dy>=m:
                        continue
                    bomb1[dx][dy] = '.'
            
    for i in range(n):
        for j in range(m):
            if bomb1[i][j] == 'O':
                bomb2[i][j] = '.'
                for x,y in ((1,0),(-1,0),(0,1),(0,-1)):
                    dx = i + x
                    dy = j + y
                    if dx<0 or dy<0 or dx>=n or dy>=m:
                        continue
                    bomb2[dx][dy] = '.'

    if k%4==3:
        for i0 in bomb1:
            print("".join(i0))
    if k%4==1:
        for i1 in bomb2:
            print("".join(i1))

# 6 7 2
# OOOOOOO
# OOOOOOO
# OOOOOOO
# OOOO.OO
# OOOOOOO
# OOOOOOO

