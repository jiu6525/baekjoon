def solution(n):
    r = ''
    while n>=3:
        r += str(n % 3)
        n = n //3
    r += str(n)
    r = list(map(int,reversed(r)))
    answer = 0
    
    for i in range(len(r)):
        answer += (3 ** int(i))*int(r[i])
    return answer




