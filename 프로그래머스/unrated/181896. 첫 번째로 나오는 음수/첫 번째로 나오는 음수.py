def solution(num_list):
    num_list = [i for i in range(len(num_list)) if num_list[i]<0]
    answer = -1 if not num_list else num_list[0]
    return answer