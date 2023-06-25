def solution(num_list):
    a,b = num_list[-1],num_list[-2]
    r = a-b if a>b else a*2
    num_list.append(r)
    return num_list
