l = list(map(int,input().split()))

def ck1():
    for i in range(8,0,-1):
        if i != l[8-i]:
            return "mixed"
    return "descending"

def ck():
    ans = "ascending"
    for i in range(1,9):
        if i != l[i-1]:
            ans = ck1()
            break
    return ans

print(ck())