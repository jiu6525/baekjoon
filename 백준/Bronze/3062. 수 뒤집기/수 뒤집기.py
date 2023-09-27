n = int(input())
for i0 in range(n):
    x = input()
    y = x[::-1]
    z = str(int(x)+int(y))
    if z == z[::-1]:
        print("YES")
    else:
        print("NO")