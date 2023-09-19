def solution(s):
    s = s.split("},{")
    for i in range(len(s)):
        s[i] = s[i].replace("{{","").replace("}}","")
        s[i] = list(map(int,s[i].split(",")))

    s = sorted(s, key=lambda x:len(x))

    answer = []
    for i in s:
        if not answer:
            answer += i
        else:
            for j in i:
                if j not in answer:
                    answer.append(j)
    return answer