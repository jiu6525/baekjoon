def solution(dartResult):
    answer = 0
    bonus = {"S":"**1", "D":"**2", "T":"**3"}
    r = [["*1" for i in range(3)] for i in range(3)]
    num = ""
    idx = -1
    for i in dartResult:
        if i.isdigit():
            num += i
        else:
            if i.isalpha():
                idx += 1
                r[idx][0] = num
                num = ""
                r[idx][1] = bonus[i]
            else:
                if i == "*":
                    if not idx:
                        r[idx][2] += "*2"
                    else:
                        r[idx][2] += "*2"
                        r[idx-1][2] += "*2"
                else:
                    r[idx][2] += "*-1"
    for i in r:
        answer += eval("".join(i))
    return answer