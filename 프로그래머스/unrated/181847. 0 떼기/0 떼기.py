def solution(n_str):
    answer = n_str
    if n_str[0] == '0':
        for i in range(len(n_str)):
            if n_str[i] != "0":
                answer = n_str[i:]
                break
    return answer