def solution(my_string):
    result = {}
    for i in my_string:
        if i in result:
            result[i] += 1
        else:
            result[i] = 1

    answer = ""
    for i in result.keys():
        answer += i
    return answer