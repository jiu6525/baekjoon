def solution(num_list):
    r =  1
    for i in num_list:
        r *= i
    answer = 1 if sum(num_list)**2>r else 0
    return answer