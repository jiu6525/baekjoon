def solution(s):
    answer = [0,0]
    r = ""
    while 1:
        answer[0] += 1
        for i in s:
            if int(i):
                r += i
            else:
                answer[1] += 1
        s = bin(len(r))[2:]
        if int(s,2) == 1:
            break
        else:
            r = ""
    return answer