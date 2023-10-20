width,length,wide = [],[],[]
n = int(input())
for i in range(6):
    x,y = map(int,input().split())
    wide.append([x,y])
    if x == 1 or x == 2:
        width.append(y)
    if x == 3 or x == 4:
        length.append(y)

# wide =[50, 160, 30, 60, 20, 100]

# width, length  = [160, 60, 100] , [50, 30, 20]
mw,ml = max(width),max(length)
sw,sl = sum(width),sum(length)

for i in range(6):
    r = wide[i-1][1] + wide[(i+1)%6][1]
    if wide[i][1] == mw:
        if wide[i][0] in (1,2):
            sl -= r
        else:
            sw -= r
    elif wide[i][1] == ml:
        if wide[i][0] in (3,4):
            sw -= r
        else:
            sl -= r

print(((mw*ml)-(sl*sw))*n)