def solution(brown, yellow):
    ad = brown+yellow
    l = []
    for i in range(1,ad+1):
        if ad%i == 0 and i>=ad//i:
            l.append([i,ad//i])
    n = len(l)//2
    print(l)

    for i in l:
        a,b = i
        if (a-2)*(b-2)==yellow:
            return [a,b]
    