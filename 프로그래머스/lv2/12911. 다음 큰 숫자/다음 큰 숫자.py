def ck(num):
    return num.count('1')


def solution(n):
    bn = bin(n)[2:]
    cn = ck(bn)
    ncn = 0
    while cn!= ncn:
        n += 1
        bn = bin(n)[2:]
        ncn = ck(bn)
    return int(bn,2)