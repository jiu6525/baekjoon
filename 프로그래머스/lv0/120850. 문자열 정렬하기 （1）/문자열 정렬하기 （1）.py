def solution(my_string):
    answer = sorted([int(i) for i in my_string if not i.isalpha()])
    return answer