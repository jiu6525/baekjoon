def solution(x):
    n = sum(list(map(int,str(x))))
    answer = False
    if x%n == 0:
        answer = True
    return answer