def dfs(v,t_happy,k_hp):
    global max_happy
    if k_hp>=hp:
        return
    if max_happy<t_happy:
        max_happy = t_happy
    if v == N:
        return
    
    happy, ihp = l[v]

    dfs(v+1,t_happy+happy,k_hp+ihp)
    dfs(v+1,t_happy,k_hp)
    
N = int(input())
hp = 100
l = []
a = list(map(int,input().split()))
b = list(map(int,input().split()))
l = list(map(list,zip(b,a)))

max_happy = 0
dfs(0,0,0)

print(max_happy)


