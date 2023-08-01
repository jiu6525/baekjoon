def solution(lottos, win_nums):
    lotto = {6:1,5:2,4:3,3:4,2:5,1:6,0:6}
    count = 0
    for i in lottos:
        for j in win_nums:
            if i==j:
                count += 1
    zero = lottos.count(0)
    result = [lotto[count+zero],lotto[count]]
    return result