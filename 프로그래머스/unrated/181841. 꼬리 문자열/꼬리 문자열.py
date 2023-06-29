
def solution(str_list, ex):
    answer = "".join([i for i in str_list if ex not in i])
    return answer