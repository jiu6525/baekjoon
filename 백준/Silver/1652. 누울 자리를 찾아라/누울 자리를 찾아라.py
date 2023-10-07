n = int(input())
lst = []
for i in range(n):
    lst.append(list(input()))

def ck(arr):
    ans = 0
    for i in arr:
        c = 0
        for j in i:
            if j == ".":
                c += 1
            else:
                if c >= 2:
                    ans += 1
                c = 0
        if c>=2:
            ans += 1
    return ans
print(ck(lst), ck(list(map(list,zip(*lst)))))