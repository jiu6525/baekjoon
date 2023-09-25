def ck(x,y):
    if len(x) != len(y):
        return " are NOT anagrams."
    for i in x:
        if i not in y or x.count(i) != y.count(i):
            return " are NOT anagrams."
    return " are anagrams."

n = int(input())
answer = []
for i in range(n):
    a,b = input().split()
    answer.append(a+" & "+b + ck(a,b))

for i in answer:
    print(i)
