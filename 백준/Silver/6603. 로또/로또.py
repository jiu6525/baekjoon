from itertools import combinations as combi
while 1:
    lst = list(map(int,input().split()))
    if lst[0] == 0:
        break
    for i in combi(lst[1:],6):
        print(" ".join(map(str,i)))
    print()