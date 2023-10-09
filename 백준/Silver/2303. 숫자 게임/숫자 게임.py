from itertools import combinations as cb

n = int(input())
def game(l):
    p = 0
    for i in cb(l,3):
        if p<sum(i)%10:
            p = sum(i)%10
    return p

lst = []
arr = []

for i in range(n):
    lst.append([i+1,game(list(map(int,input().split())))])

lst.sort(key=lambda x:(-x[1],-x[0]))
print(lst[0][0])