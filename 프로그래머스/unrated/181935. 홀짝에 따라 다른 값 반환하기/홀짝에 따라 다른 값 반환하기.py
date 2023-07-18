def solution(n):
    answer = sum([i for i in range(1,n+1) if i%2!=0]) if n%2!=0 else sum([i**2 for i in range(1,n+1) if i%2==0])
    return answer
