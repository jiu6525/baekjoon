n = int(input())
l = []
for i in range(n):
    l.append(int(input()))

print("Junhee is cute!" if l.count(1) > l.count(0) else "Junhee is not cute!")