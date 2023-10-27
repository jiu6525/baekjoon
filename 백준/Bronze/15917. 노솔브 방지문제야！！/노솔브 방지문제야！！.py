import sys
input = sys.stdin.readline
for i in range(int(input())):
    a = int(input())
    t = int(bin(a)[2:])
    print(1 if t&(-t) == a else 0)