def solution(n):
    w = "수박"
    answer = w*(n//2)
    if n%2:
        answer += w[0]

    return answer