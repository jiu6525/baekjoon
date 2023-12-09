for i0 in range(int(input())):
    ans = 0
    n,m = map(int,input().split())
    box = []
    for i in range(m):
        r,c = map(int,input().split())
        box.append(r*c)
    box.sort(reverse=True)
    while n > 0:
        n -= box[ans]
        ans += 1
    print(ans)