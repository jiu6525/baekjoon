x,y,w,s = map(int,input().split())
ans1 = (x+y)*w
if (x+y)%2==0:
    ans2 = max(x,y) * s
else:
    ans2 = (max(x,y)-1 )* s + w
ans3 = (min(x,y) * s)+ ((max(x,y)-min(x,y))*w)
print(min(ans1,ans2,ans3))