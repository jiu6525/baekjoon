def ex(val, digits):
    return round(val+10**(-len(str(val))-1), digits)

r = {"A+": 4.3, "A0": 4.0, "A-": 3.7,"B+": 3.3, "B0": 3.0, "B-": 2.7,"C+": 2.3, "C0": 2.0, "C-": 1.7,"D+": 1.3, "D0": 1.0, "D-": 0.7,"F": 0.0}
n = int(input())
answer = 0
score = 0
for i in range(n):
    l = input().split()[1:]
    score += int(l[0])
    answer += int(l[0])*r[l[1]]

answer = ex(answer/score,2)

print(f'{answer:0.2f}')