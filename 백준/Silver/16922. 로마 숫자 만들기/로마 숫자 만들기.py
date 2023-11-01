from itertools import combinations_with_replacement as combi
ans = set()
for i in combi([1,5,10,50],int(input())):
    ans.add(sum(i))
print(len(ans))