def solution(my_string, is_suffix):
    word = []
    for i in range(len(my_string)):
        word.append(my_string[i:])
    return 1 if is_suffix in word else 0