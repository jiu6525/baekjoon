for i in range(int(input())):
    n,m = map(int,input().split())
    lst = sorted(list(map(int,input().split())))
    print(lst[m-1])