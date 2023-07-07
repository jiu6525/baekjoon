def solution(arr1, arr2):
    answer = 0
    n,m = len(arr1),len(arr2)
    s1,s2 = sum(arr1),sum(arr2)
    if n==m:
        if s1>s2:
            answer = 1
        elif s1==s2:
            answer = 0
        else:
            answer = -1
    elif n>m:
        answer = 1
    else:
        answer = -1
    return answer