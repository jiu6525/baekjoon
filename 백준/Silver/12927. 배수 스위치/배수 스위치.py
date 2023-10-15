lst = [0] + list(input())
c = 0
for i in range(1,len(lst)):
    if lst[i] == "Y":
        c += 1
        for j in range(i,len(lst),i):
            if lst[j] == "N":
                lst[j] = "Y"
            else:
                lst[j] = "N"
    if lst[1:].count("N")+1 == len(lst):
        print(c)
        break
else:
    print(-1)
        