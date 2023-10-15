lst = list(map(int,input().split()))
slst = [1,2,3,4,5]
while lst != slst:
    for i in range(1,len(lst)):
        if lst[i-1]>lst[i]:
            lst[i-1],lst[i] = lst[i],lst[i-1]
            print(" ".join(map(str,lst)))