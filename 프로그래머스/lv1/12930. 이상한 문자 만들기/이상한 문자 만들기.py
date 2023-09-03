def solution(s):
    answer = []
    s = s.split(" ")
    for i in range(len(s)):
        r = ""
        for j in range(len(s[i])):
            if j%2==0:
                r += s[i][j].upper()
            else:
                r += s[i][j].lower()
        answer.append(r)

    return " ".join(answer)