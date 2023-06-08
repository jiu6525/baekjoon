def solution(s):
    l = []
    for i in s:
        if not l:
            l.append(i)
        else:
            x = l.pop()
            if i == x:
                continue
            else:
                l.append(x)
                l.append(i)
    answer = 1 if not l else 0
    return answer