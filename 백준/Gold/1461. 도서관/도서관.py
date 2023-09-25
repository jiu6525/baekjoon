def ck(num1,num2):
    answer = 0
    for i in range(len(num1)-k-1,-1,-k):
        answer += num1[i]*2
    for i in range(len(num2)-1,-1,-k):
        answer += num2[i]*2
    return answer

n,k = map(int,input().split())
arr = list(map(int,input().split()))
plus = [0]+[i for i in arr if i>0]
minus = [0]+[i for i in arr if i<0]
minus = [abs(i) for i in minus]
plus.sort()
minus.sort()
mxp,mxm = max(plus),max(minus)
root = -1 if mxm>mxp else 1

if root == 1:
    r = ck(plus,minus)
    r += mxp
else:
    r = ck(minus,plus)
    r += mxm

print(r)

