fBody, fTail = input().split()
mBody, mTail = input().split()

color = []

if fBody not in color:
    color.append(fBody)

if fTail not in color:
    color.append(fTail)

if mBody not in color:
    color.append(mBody)

if mTail not in color:
    color.append(mTail)

color.sort()

for i in range(len(color)):
    for j in range(len(color)):
        print(color[i], color[j])