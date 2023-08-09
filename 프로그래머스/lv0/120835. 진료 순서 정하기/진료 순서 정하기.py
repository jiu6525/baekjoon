def solution(emergency):
    idx = sorted(emergency, reverse=True)
    return  [idx.index(emergency[i])+1 for i in range(len(idx))]