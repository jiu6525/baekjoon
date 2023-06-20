def solution(k, score):
    answer = []
    result = []
    for i in score:
        if len(answer)<k:
            answer.append(i)
        else:
            ms = answer.index(min(answer))
            if i > min(answer):
                answer.pop(ms)
                answer.append(i)
            else:
                pass
        result.append(min(answer))

    return result