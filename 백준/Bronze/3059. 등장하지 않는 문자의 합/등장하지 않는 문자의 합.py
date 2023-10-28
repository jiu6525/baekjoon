for i0 in range(int(input())):
    a = 2015
    s = set(input())
    for i in s:
        a -= ord(i)
    print(a)
