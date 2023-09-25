n,m = map(int,input().split())
a = set(map(int,input().split()))
b = set(map(int,input().split()))

answer = sorted(a-b)
print(len(answer))
print(" ".join(map(str,answer)))