def solution(lst):
    lst.pop(lst.index(min(lst)))
    answer = [-1] if len(lst)==0 else lst
    return answer