import numpy as np

def solution(arr1, arr2):

    a = np.array(arr1)
    b = np.array(arr2)
    c = np.dot(a, b)
    
    answer = []
    for i in c:
        answer.append(list(map(int,i)))

    return answer