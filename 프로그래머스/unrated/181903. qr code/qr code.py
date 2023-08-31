def solution(q, r, code):
    return "".join([code[i] for i in range(len(code)) if i%q==r])