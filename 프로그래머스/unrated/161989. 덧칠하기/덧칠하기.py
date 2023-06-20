def solution(n, m, section):
    answer = 1
    r = m + section[0]
    for i in section:
        if i < r:
            continue
        else:
            answer += 1
            r = m + i
    return answer