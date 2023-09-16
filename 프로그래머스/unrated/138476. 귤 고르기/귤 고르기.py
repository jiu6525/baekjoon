def solution(k, tangerine):
    count = {}
    result = 0
    for i in tangerine:
        if i in count:
            count[i] += 1
        else:
            count[i] = 1

    count = sorted(count.items(),reverse=True, key=lambda x:x[1])
    for z,(i,j) in enumerate(count):
        result += j
        if result >= k:
            return z+1
            
    