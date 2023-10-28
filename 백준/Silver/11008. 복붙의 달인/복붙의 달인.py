for i in range(int(input())):
    s,p = input().split()
    print(len(s)-(s.count(p)*len(p))+s.count(p))