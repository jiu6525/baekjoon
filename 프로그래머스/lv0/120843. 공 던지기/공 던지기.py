def solution(numbers, k):
    answer = 0
    idx = 0
    while k-1>0:
        idx += 2
        k -= 1
    return numbers[(idx)%len(numbers)]