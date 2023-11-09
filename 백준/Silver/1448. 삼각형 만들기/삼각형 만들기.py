lst = [int(input()) for i in range(int(input()))]
lst.sort(reverse=True)
ans = 0
for i in range(len(lst)-2):
    if lst[i] < lst[i+1] + lst[i+2]:
        ans = lst[i]+lst[i+1]+lst[i+2]
        break

print(ans if ans else -1)