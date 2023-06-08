def solution(n):
    answer = 0
    for i in range(1,n+1):
        c = 0
        for j in range(i,n+1):
            c += j
            if c == n:
                answer += 1
                break
            elif c>n:
                break
    return answer