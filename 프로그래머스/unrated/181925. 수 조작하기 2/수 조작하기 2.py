def solution(numLog):
    answer = ""
    for i in range(len(numLog)-1):
        r = numLog[i+1] - numLog[i]
        if r == 1:
            answer += "w"
        elif r == -1:
            answer += "s"
        elif r == 10:
            answer += "d"
        else:
            answer += "a"
    return answer