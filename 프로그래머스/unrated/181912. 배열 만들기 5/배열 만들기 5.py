def solution(intStrs, k, s, l):
    return [int(i[s:s+l]) for i in intStrs if int(i[s:s+l])>k]