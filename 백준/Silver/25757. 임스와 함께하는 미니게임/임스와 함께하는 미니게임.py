n,m = input().split()
lst = set()
for i in range(int(n)):
    lst.add(input())
lst = len(lst)
ans = lst if m == 'Y' else (lst//2 if m == 'F' else lst//3)
print(ans)