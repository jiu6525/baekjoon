def solution(num_list, n):
    answer = [num_list[i * n:(i + 1) * n] for i in range((len(num_list) + n - 1) // n )] 
    return answer