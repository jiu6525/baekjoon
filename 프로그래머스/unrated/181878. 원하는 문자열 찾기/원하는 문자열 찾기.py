def solution(myString, pat):
    answer = 1 if pat.upper() in myString.upper() else 0
    return answer