def solution(strArr):
    answer = {}
    for i in strArr:
        if len(i) in answer:
            answer[len(i)] += 1
        else:
            answer[len(i)] = 1
    return max([j for i,j in answer.items()])