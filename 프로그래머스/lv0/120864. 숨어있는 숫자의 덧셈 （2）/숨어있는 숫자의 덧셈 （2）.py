def solution(my_string):
    answer = 0
    num = ""
    for i in my_string:
        if not i.isalpha():
            num += i
            continue
        if num:
            answer += int(num)
            num = ""
    if num:
        answer += int(num)

    return answer