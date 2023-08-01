def solution(num, k):
    num,k = str(num),str(k)
    answer = num.find(k)
    return answer+1 if answer+1 else -1