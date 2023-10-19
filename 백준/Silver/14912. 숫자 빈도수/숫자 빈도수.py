n,k = map(int,input().split())
lst = "".join([str(i) for i in range(1,int(n+1))])
print(lst.count(str(k)))