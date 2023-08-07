def ck(answer):
    if answer<=1:
        return 1
    return answer * ck(answer-1)



def solution(n):
    answer = 1
    while 1:
        if n < ck(answer):
            break
        answer += 1
    return answer-1