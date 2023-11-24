while 1:
    n = int(input())
    if n == 0:
        break
    book = [0 for i in range(n+1)]
    a = input().split(",")
    for i in a:
        b = list(map(int,(i.split("-"))))
        if len(b)==2:
            if b[0] > b[1]:
                continue
            else:
                if b[0] > n:
                    continue
                else:
                    if b[1] < n:
                        for j in range(b[0],b[1]+1):
                            book[j] = 1
                    else:
                        for j in range(b[0],n+1):
                            book[j] = 1
        else:
            if b[0] <= n:
                book[b[0]] = 1

    print(book.count(1))


    # 10-15,25-28,8-4,13-20,9,8-8