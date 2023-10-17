word = input()
c = 0
for i in range(int(input())):
    ckword = input()
    if word in ckword*2:
        c += 1

print(c)