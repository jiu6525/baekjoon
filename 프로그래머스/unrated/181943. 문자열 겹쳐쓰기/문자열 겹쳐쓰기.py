def solution(my_string, overwrite_string, s):
    return my_string[:s] + overwrite_string + my_string[len(overwrite_string)+s:]