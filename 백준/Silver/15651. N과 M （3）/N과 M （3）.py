n,m = map(int,input().split())

lst = []

def dfs():
    if len(lst) == m:
        for i in range(m):
            print(lst[i],end=' ')
        print('')
        return
    for i in range(1,n+1):
        lst.append(i)
        dfs()
        lst.pop()
        
dfs()        