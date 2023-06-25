def solution(my_string):
    answer = 0 
    for i in my_string:
        if not i.isalpha():
            answer += int(i)

    return answer