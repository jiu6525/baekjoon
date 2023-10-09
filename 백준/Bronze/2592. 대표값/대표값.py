l = []
for i in range(10):
    l.append(int(input()))
d = {}
for i in l:
    if i in d:
        d[i] += 1
    else:
        d[i] = 0
d = sorted(d.items(), key=lambda x:x[1], reverse=True)
print(sum(l)//len(l))
print(d[0][0])