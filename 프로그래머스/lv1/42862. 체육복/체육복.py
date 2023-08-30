def solution(n, lost, reserve):
    spare = set(lost)&set(reserve)
    lost = sorted(list(filter(lambda x : x not in spare,lost)))
    reserve = sorted(list(filter(lambda x : x not in spare,reserve)))
    for i in reserve:
        if i-1 in lost:
            lost.pop(lost.index(i-1))
        elif i+1 in lost:
            lost.pop(lost.index(i+1))
    return n-len(lost)