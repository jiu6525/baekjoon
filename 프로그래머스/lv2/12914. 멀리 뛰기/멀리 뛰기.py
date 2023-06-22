def solution(n):
    k = [0 for i in range(n+1)]
    k[0],k[1] = 1,1
    for i in range(2,len(k)):
        k[i] = k[i-2] + k[i-1]
    return k[-1]%1234567