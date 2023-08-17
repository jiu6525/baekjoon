def solution(s):
    answer = []
    r = set(s)
    for i in r:
        if s.count(i) == 1:
            answer += i
    return "".join(sorted(answer))