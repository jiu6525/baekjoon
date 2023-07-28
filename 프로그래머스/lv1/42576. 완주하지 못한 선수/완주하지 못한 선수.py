def solution(participant, completion):
    p = {}
    for i in participant:
        if i in p:
            p[i] += 1
        else:
            p[i] = 1

    for i in completion:
        if i in p:
            p[i] -= 1

    answer = [i for i in p.keys() if p[i]]
    return answer[0]