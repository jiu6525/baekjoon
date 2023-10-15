A = int(input())
B = int(input())
C = int(input())
D = int(input())
E = int(input())
ans = 0
if A<0:
    ans += abs(A*C)
    A = 0
if A == 0:
    ans += D
ans += (B-A)*E
print(ans)