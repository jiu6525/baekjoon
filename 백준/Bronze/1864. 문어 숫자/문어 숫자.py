d = {"-":0,"\\":1,"(":2,"@":3,"?":4,">":5,"&":6,"%":7,"/":-1}
while 1:
    lst = input()
    if lst == "#":
        break
    ans = 0
    for i in range(len(lst)):
        ans += d[lst[i]] * (8 ** (len(lst)-i-1))

    print(ans)
