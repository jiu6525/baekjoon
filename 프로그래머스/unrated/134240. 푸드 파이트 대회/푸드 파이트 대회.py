def solution(food):
    r = ""

    for i in range(1,len(food)):
        if food[i]//2>=1:
            r += str(i) * (food[i]//2)

    r1 = r[::-1]
    result = r + '0' + r1
    return result