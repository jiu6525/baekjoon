k = int(input())
for i in range(k):
    n,m = map(int,input().split())
    a = list(map(int,input().split()))
    b = list(map(int,input().split()))
    a.sort(reverse=True)
    b.sort()
    count = 0
    for i in a:
        for j in b:
            if i>j:
                count += 1
            else:
                break
    print(count)
