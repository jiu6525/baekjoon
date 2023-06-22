def solution(n):
    count = 0
    while n>0:
        count += n % 2
        n //= 2

    return count