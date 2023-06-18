from itertools import combinations
def solution(numbers):
    answer = []
    for i in combinations(numbers,2):
        if sum(i) not in answer:
            answer.append(sum(i))

    answer.sort()
    return answer