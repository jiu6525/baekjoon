c = int(input())
n = list(map(int, input().split()))

for i in range(c):
    if n[i] == (int(n[i] ** 0.5) ** 2):
        print(1, end = " ")
    else:
        print(0, end = " ")