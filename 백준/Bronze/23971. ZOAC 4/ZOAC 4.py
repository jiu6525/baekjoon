h,w,n,m = map(int,input().split())
print((w//(m+1) if w%(m+1) == 0 else w//(m+1)+1) * (h//(n+1) if h%(n+1) == 0 else h//(n+1)+1))