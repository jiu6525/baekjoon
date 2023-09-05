def solution(survey, choices):
    l = {1:{"R":0,"T":0},2:{"C":0,"F":0},3:{"J":0,"M":0},4:{"A":0,"N":0}}
    num = [0,3,2,1,0,1,2,3]
    # survey = ["TR", "RT", "TR"]
    # choices = [7, 1, 3]

    for i in range(len(survey)):
        word = list(survey[i])
        for j in range(1,5):
            if choices[i]>3:
                if word[1] in l[j]:
                    l[j][word[1]] += num[choices[i]]
            else:
                if word[0] in l[j]:
                    l[j][word[0]] += num[choices[i]]

    answer = ""
    for i in range(1,5):
        count = max(l[i].values())  
        for j in l[i]:
            if l[i][j] == count:
                answer += j
                break
    return answer