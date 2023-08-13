def solution(arr, flag):
    x = []
    for i in range(len(flag)):
        if flag[i]:
            a = [arr[i] for j in range(arr[i]*2)]   
            x += a
        else:
            x = x[:len(x)-arr[i]]

    return x