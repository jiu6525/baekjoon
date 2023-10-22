while 1:
    lst = list(map(int,input().split()))
    if sum(lst) == 0:
        break
    lst.sort()
    if lst[2]>=lst[1]+lst[0]:
        print("Invalid")
    elif any(lst.count(lst[i])==3 for i in range(3)):
        print("Equilateral")
    elif any(lst.count(lst[i])==2 for i in range(3)):
        print("Isosceles")
    else:
        print("Scalene")
