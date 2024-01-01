T = int(input())
 
for _ in range(T):
    n = int(input())
    before = list(map(str,input().split()))
    after = list(map(str,input().split()))
    
    if before == after or sorted(before) == sorted(after):
        print("NOT CHEATER")
    else:
        print("CHEATER")