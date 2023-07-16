def solution(my_string):
    chk = ord("l")
    answer = ''
    for i in my_string:
        if ord(i) < chk:
            answer += "l"
            continue
        answer += i

    return answer