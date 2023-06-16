def solution(my_string):
    m = ['a','e','i','o','u']
    answer = ''
    for i in my_string:
        if i not in m:
            answer += i
    return answer