def solution(want, number, discount):
    count = 0
    for i in range((len(discount)-9)):
        ck = discount[i:i+10]
        c = 0
        for j in range(len(want)):
            if ck.count(want[j]) == number[j]:
                c +=1
            else:
                break
        if c==len(want):
            count += 1

    return count