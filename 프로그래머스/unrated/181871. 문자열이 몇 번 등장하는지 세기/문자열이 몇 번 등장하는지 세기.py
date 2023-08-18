def solution(myString, pat):
    lp = len(pat)
    answer = 0
    for i in range(len(myString)-lp+1):
        if pat == myString[i:i+lp]:
            answer += 1

    return answer