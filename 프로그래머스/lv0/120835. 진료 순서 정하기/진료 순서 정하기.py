def solution(emergency):
    idx = sorted(emergency, reverse=True)
    answer = [idx.index(emergency[i])+1 for i in range(len(idx))]
    return answer