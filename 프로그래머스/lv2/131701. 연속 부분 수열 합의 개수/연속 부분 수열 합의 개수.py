def solution(e):
    k = len(e)
    c = e+e
    answer = set()
    for i in range(k):
        for j in range(k):
            answer.add(sum(c[i:i+j]))
    
    return len(answer)