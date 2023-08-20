def solution(arr):
    la = len(arr)
    idx = 1
    while idx<la:
        idx *= 2

    for i in range(idx-la):
        arr.append(0)
    return arr