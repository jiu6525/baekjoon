from itertools import permutations as per
def solution(k, dungeons):
    cnt_lst = []
    for dungeon in per(range(len(dungeons)),len(dungeons)):
        temp_k = k
        cnt = 0
        for i in dungeon:
            min_k, use_k = dungeons[i]
            if temp_k >= min_k:
                cnt += 1
                temp_k -= use_k
        cnt_lst.append(cnt)
    
    return max(cnt_lst)
            
    
    