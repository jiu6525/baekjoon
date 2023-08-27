def solution(x, y):
    xl = [x.count(str(i)) for i in range(10)]
    yl = [y.count(str(i)) for i in range(10)]

    answer = ""
    for i in range(9,-1,-1):    
        if min(xl[i],yl[i]):
            answer += str(i) * min(xl[i],yl[i])

    if answer=="":
        answer='-1' 
    elif answer[0]=='0': 
        answer='0'

    return answer