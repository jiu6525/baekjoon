t,n=map(int,input().split())
days=["Mon","Tue","Wed","Thu","Fri"]
for _ in range(n):
    tmp=list(input().split())
    if tmp[0]==tmp[2]: t-= int (tmp[3])- int(tmp[1])
    else: t-= 24*(days.index(tmp[2])-days.index(tmp[0]))+int(tmp[3])-int(tmp[1])
if t>48: print(-1)
elif t>0:print(t)
elif t>-49 : print(0)