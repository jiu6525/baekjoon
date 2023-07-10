def solution(my_string, is_prefix):
    answer = 0 if len(is_prefix) > len(my_string) or my_string[:len(is_prefix)] != is_prefix else 1
    return answer