n = int(input())
for i in range(n,-1,-1):
    if any(i0 for i0 in str(i) if i0 not in ('4','7')):
        continue
    else:
        print(i)
        break