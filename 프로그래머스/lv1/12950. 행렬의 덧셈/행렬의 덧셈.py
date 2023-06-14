def solution(arr1, arr2):
    answer = []
    for i in range(len(arr1)):
        r = []
        for j in range(len(arr1[0])):
            r.append(arr1[i][j]+arr2[i][j])
        answer.append(r)

    return answer