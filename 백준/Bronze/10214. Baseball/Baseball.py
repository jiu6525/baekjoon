for i in range(int(input())):
    y,k = 0,0
    for j in range(9):
        a,b = map(int,input().split())
        y += a
        k += b

    ans = "Yonsei" if y>k else ("Korea" if k>y else "Draw")
    print(ans)