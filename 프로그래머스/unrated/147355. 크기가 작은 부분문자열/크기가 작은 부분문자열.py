def solution(t, p):
    ip = len(p)
    answer = 0
    for i in range(0, len(t)-ip+1):
        if int(t[i:i+ip]) <= int(p):
            answer += 1
    return answer