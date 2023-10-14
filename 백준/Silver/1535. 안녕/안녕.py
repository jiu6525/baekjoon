def dfs(v,n_happy,n_hp):
    global max_happy
    if n_hp>= hp:
        return
    if n_happy > max_happy:
        max_happy = n_happy
    if v == n:
        return
    ihappy, ihp = lst[v]
    dfs(v+1,n_happy+ihappy,n_hp+ihp)
    dfs(v+1,n_happy,n_hp)

n = int(input())
hp = 100
damage_l = list(map(int,input().split()))
happy_l = list(map(int,input().split()))
lst = list(map(list,zip(happy_l,damage_l)))
max_happy = 0

dfs(0,0,0)
print(max_happy)