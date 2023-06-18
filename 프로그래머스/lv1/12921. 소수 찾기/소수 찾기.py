def solution(n):
    m = int(n**0.5)
    result = [True]*(n+1)

    for i in range(2,m+1):
        for j in range(i+i,n+1,i):
            if result[j]:
                result[j] = False
    
    return len([i for i in range(len(result)) if result[i] and i>1])