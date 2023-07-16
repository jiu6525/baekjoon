def solution(cipher, code):
    idx = code -1
    answer = cipher[idx] + "".join([cipher[i] for i in range(len(cipher)) if (i-idx)%code == 0 and i>idx])
    return answer