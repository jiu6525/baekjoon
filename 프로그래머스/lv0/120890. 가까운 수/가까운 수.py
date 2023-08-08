def solution(array, n):
    array.sort()
    answer = list(map(lambda x:abs(x-n),array))
    return array[answer.index(min(answer))]