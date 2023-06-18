def solution(k, m, score):
    score.sort(reverse=True)
    r = []
    answer = 0
    for i in range(len(score)):
        r.append(score[i])
        if len(r) == m:
            answer += min(r)*m
            r = []

    return answer