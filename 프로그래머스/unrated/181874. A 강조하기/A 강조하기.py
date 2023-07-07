def solution(myString):
    answer = ""
    myString = myString.replace("a","A")
    for i in myString:
        if i !="A":
            answer += i.lower()
        else:
            answer += i
    return answer