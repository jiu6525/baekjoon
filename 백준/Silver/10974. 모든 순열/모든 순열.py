from itertools import permutations as pm
n = int(input())
# n = 3
lst = [i for i in range(1,n+1)]

for i in pm(lst):
    print(*i)