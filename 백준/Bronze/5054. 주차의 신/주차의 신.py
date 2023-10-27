for i in range(int(input())):
    n = int(input())
    lst = list(map(int,input().split()))
    lst.sort()
    print((lst[-1]-lst[0])*2)