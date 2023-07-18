def solution(my_strings, parts):
    answer = ''
    for i,j in enumerate(parts):
        answer += my_strings[i][j[0]:j[1]+1]
    return answer
