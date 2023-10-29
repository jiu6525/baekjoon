for i0 in range(int(input())):
    d = {}
    for i in range(int(input())):
        a,b = input().split()
        d[a] = int(b)
    d = sorted(d.items(), key=lambda x:-x[1])
    print(", ".join([i for i,j in d]))