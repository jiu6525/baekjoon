for i0 in range(1,int(input())+1):
    n = int(input())
    lst = []
    ans = 0
    for i in range(n):
        lst.append(int(input()))
    avg = sum(lst)//n
    for i in range(n):
        if lst[i] < avg:
            ans += avg-lst[i]
    print(f'#{i0} {ans}')