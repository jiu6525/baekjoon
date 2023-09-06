def solution(arr, k):
    answer = []
    for i in arr:
        if i not in answer and len(answer)<k:
            answer.append(i)

    return answer if len(answer)==k else answer + [-1 for i in range(k-len(answer))]
