n,m = map(int,input().split())
lst = [int(input()) for i in range(n)]
lst.sort(reverse=True)
print(sum(lst[:m]))