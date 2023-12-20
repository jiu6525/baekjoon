u, n = map(int, input().split())
price_list = [int(u)+1 for _ in range(u+1)]
name_list = [None for _ in range(u+1)]
for i in range(n):
    name, price = input().split()
    index_p = int(price)
    if price_list[index_p] == u+1:
        price_list[index_p] = 1
    else:
        price_list[index_p] += 1
    if not name_list[index_p]:
        name_list[index_p] = name

index_m = price_list.index(min(price_list))
print(name_list[index_m], index_m)