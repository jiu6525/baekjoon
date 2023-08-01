def solution(order):
    n = ["3","6","9"]
    order = str(order)
    answer = 0
    for i in n:
        answer += order.count(i)
    return answer