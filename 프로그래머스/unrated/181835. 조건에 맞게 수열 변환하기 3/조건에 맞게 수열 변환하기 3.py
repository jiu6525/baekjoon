def solution(arr, k):
    if k % 2 ==0:
        arr = [i+k for i in arr]
    else:
        arr = [i*k for i in arr]
    return arr
