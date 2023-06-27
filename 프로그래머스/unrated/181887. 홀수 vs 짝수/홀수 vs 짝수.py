def solution(num_list):
    od = sum([num_list[i] for i in range(len(num_list)) if i%2 != 0])
    ev = sum([num_list[i] for i in range(len(num_list)) if i%2 == 0])
    answer = od if od>ev else ev
    return answer