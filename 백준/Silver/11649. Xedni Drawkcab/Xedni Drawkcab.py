lst = []
for i in range(int(input())):
    lst.append(input()[::-1])
for i in sorted(lst):
    print(i)