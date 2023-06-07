def solution(n):
    answer = 0
    while n != 1:
        answer += 1
        if answer >= 500:
            return -1
        else:
            if n%2==0:
                n //= 2
            else:
                n = n*3 + 1

    return answer