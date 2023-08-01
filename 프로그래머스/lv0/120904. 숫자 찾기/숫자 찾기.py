def solution(num, k):
    answer = str(num).find(str(k))
    return answer+1 if answer+1 else -1