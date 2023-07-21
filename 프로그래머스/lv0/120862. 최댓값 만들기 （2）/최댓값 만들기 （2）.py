from itertools import combinations
def solution(numbers):
    answer = []
    for i,j in combinations(numbers,2):
        answer.append(i*j)
    return max(answer)