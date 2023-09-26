n = int(input())
for i0 in range(n):
    k = int(input())
    l = list(map(int,input().split()))
    l.reverse()
    a = l[0]
    answer = 0
    for i in range(1,k):
        if l[i] < a:
            answer += a-l[i]
        else:
            a = l[i]

    print(answer)