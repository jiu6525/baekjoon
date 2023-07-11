def solution(arr, n):
    idx = len(arr)
    if idx %2==0:
        for i in range(idx):
            if i%2!=0:
                arr[i] = arr[i] +n
    else:
        for i in range(idx):
            if i%2==0:
                arr[i] = arr[i] +n
    return arr