def solution(s):
    s = list(map(int,s.split()))
    r = str(min(s)) + " " + str(max(s))
    return r