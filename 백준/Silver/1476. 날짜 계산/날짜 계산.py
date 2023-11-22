e,s,m = 15,28,19
a,b,c = map(int,input().split())
year = 1

while 1:
    if ((year-a)%e == 0) and ((year-b)%s == 0) and ((year-c)%m == 0):
        break
    year += 1

print(year)
