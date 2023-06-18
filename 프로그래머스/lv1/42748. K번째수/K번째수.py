def solution(array, commands):
    answer = []
    for s,e,k in commands:
        answer.append(sorted(array[s-1:e])[k-1])
    return answer