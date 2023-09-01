def solution(arr):
    if arr.count(2):
        idx1 = arr.index(2)
        idx2 = len(arr)-arr[::-1].index(2)
        return arr[idx1:idx2]
    return [-1]