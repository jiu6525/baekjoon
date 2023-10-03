d = {"@":"*3","%":"+5","#":"-7"}
l = int(input())
for i in range(l):
    n = list(input().split())
    num = n[0]
    for i in n:
        if i in d:
            num += d[i]
            num = str(eval(num))

    print(f'{float(num):.2f}')