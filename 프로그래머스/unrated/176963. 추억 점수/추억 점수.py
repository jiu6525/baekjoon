def solution(name, yearning, photo):
    grade = dict()
    answer = []
    for i in range(len(name)):
        grade[name[i]] = yearning[i]
    for p in photo:
        r = 0
        for i in p:
            if i in grade:
                r += grade[i] 
        answer.append(r) 
    return answer