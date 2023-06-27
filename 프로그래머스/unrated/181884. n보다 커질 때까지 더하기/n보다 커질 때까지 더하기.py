def solution(numbers, n):
    answer = 0
    idx = 0
    while 1:
        if idx == len(numbers):
            idx = 0
        answer += numbers[idx]
        idx += 1
        if answer > n:
            return answer