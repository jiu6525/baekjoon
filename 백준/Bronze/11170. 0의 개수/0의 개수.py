for i in range(int(input())):
    cnt = 0 
    n,m = map(int,input().split())
    for j in range(n,m+1):
        if "0" in str(j):
            cnt += str(j).count("0")
    print(cnt)
        