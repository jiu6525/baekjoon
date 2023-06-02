def solution(n):
    
    for x in range(2,n+1):
        if n%x==1:
            return x
        
