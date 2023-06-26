from functools import reduce

def solution(arr):
    if len(arr)<11:
        return reduce(lambda x, y: x * y, arr)
    else:
        return sum(arr)

