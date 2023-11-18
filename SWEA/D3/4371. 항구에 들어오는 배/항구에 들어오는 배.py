for i0 in range(1,int(input())+1):
    lst = [int(input()) for i in range(int(input()))]
    happy = []
    ans = 0
    for i in range(1,len(lst)):
        if lst[i] in happy:
            continue
        else:
            gap = lst[i]-1
            for j in range(gap+1,lst[-1]+1,gap):
                happy.append(j)
        ans += 1
                       
    print(f'#{i0} {ans}')

