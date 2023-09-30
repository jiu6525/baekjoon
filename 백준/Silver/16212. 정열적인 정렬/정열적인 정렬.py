n = int(input())
lst = list(map(int,input().split()))
lst.sort()
print(" ".join(map(str,lst)))