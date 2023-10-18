def distance(x,y):
    if x == 1:
        return y
    elif x == 4:
        return w+y
    elif x == 2:
        return w+h+w-y
    elif x == 3:
        return w+h+w+h-y
    
w,h = map(int,input().split())
n = int(input())
arr = []
for i in range(n+1):
    direction, location = map(int,input().split())
    arr.append(distance(direction,location))

target = arr[-1]
totalround = (w+h)*2

ans = 0
for i in range(n):
    shop = abs(arr[i]-target)
    ans += min(shop,totalround-shop)

print(ans)