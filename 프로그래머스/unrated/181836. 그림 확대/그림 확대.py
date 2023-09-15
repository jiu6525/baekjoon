def solution(picture, k):
    answer = []
    for i in picture:
        key = ""
        for j in i:
            key += (j*k)
        for j in range(k):
            answer.append(key)
    return answer