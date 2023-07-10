def solution(a, b):
    answer =2*(a+b) if (a+b)%2 != 0 else (a**2+b**2 if a%2!=0 and b%2!=0 else abs(a-b))
    return answer