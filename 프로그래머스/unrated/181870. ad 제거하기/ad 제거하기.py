def solution(strArr):
    answer = []
    for i in strArr:
        if "ad" in i:
            continue
        else:
            answer.append(i)

    return answer