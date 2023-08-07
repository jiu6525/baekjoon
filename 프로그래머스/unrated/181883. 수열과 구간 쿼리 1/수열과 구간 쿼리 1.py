def solution(arr, queries):
    for i,j in queries:
        for k in range(i,j+1):
            arr[k] += 1
    return arr