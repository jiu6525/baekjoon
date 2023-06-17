def solution(d, budget):
    d.sort()
    answer = 0
    c= 0
    answer = 0 
    for i in d:
        if budget - c -i >= 0 :
            answer += 1
            c += i
        else:
            break
    return answer