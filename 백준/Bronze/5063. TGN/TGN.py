n = int(input())
for i in range(n):
    a,b,c = map(int,input().split())
    ans = "advertise" if b-c>a else ("do not advertise" if b-c<a else "does not matter")
    print(ans)