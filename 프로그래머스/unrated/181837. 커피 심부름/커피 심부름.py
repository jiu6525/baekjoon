def solution(order):
    answer = 0
    for i in order:
        if "latte" in i:
            answer += 500
        answer += 4500
    return answer