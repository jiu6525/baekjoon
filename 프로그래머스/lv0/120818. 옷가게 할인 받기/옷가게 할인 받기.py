def solution(price):
    num = 0.80 if price>=500000 else (0.9 if price>=300000 else 0.95 if price>=100000 else 1)
    return int(price*num)