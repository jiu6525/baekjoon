l = []
mx = 0
for i in range(5):
    word = list(input())
    l.append(word)
    if len(word)>mx:
        mx = len(word)

for i in l:
    if len(i)<mx:
        i += '_'*(mx-len(i))

r = list(map(list,zip(*l)))

for i in r:
    for j in i:
        if j == '_':
            continue
        print(j,end='')