def solution(A,B):
    A.sort(reverse=True)
    B.sort()
    answer = 0
    for i in range(len(A)):
        answer += A[i] * B[i]

    return answer   