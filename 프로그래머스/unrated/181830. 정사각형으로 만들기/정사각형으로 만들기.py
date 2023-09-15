def solution(arr):
    la = len(arr)
    for i in range(len(arr)):
        if arr[i] != la:
            arr[i] += [0]*(la-len(arr[i]))
    lr = len(arr[0])

    if la != lr:
        arr += [[0 for i in range(lr)]]*(lr-la)

    return arr