def solution(s, skip, index):
    l,answer = "",""

    for i in range(97,123):
        if chr(i) not in skip:
            l += chr(i)

    for i in s:
        idx = l.index(i)+index
        if idx >= len(l):
            answer += l[idx%(len(l))]
        else:
            answer += l[idx]
    return answer