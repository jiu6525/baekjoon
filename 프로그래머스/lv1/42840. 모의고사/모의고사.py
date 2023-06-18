def ck(answers,n):
    c = 0 
    for i in range(len(answers)):
        if str(answers[i]) == n[i%len(n)]:
            c += 1
    return c

def solution(answers):
    s = ["12345","21232425","3311224455"]
    mc = max(ck(answers,s[0]),ck(answers,s[1]),ck(answers,s[2]))
    answer = []

    for i in range(3):
        if ck(answers,s[i]) == mc :
            answer.append(i+1)

    return answer