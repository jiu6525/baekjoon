import sys
input = sys.stdin.readline
k,l = map(int,input().split())
lst = {}
for i in range(l):
    lst[input().strip()] = i

lst = sorted(lst.items(),key= lambda x:x[1])
for i in range(k):
    if len(lst)>i:
        print(lst[i][0])
    else:
        break