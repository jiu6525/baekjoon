from itertools import combinations
def s(n):
    m = int(n**0.5)
    result = [True]*(n+1)

    for i in range(2,m+1):
        for j in range(i+i,n+1,i):
            if result[j]:
                result[j] = False
    
    return [i for i in range(len(result)) if result[i] and i>1]


def solution(nums):
    l = s(sum(nums))
    c = 0
    
    for i in combinations(nums,3):
        if sum(i) in l:
            c += 1
    return c
