def solution(my_strings, parts):
    answer = ''
    for i,(s,e) in enumerate(parts):
        answer += my_strings[i][s:e+1]
    return answer