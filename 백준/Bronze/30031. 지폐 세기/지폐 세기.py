d = {136:1000,142:5000,148:10000,154:50000}
print(sum([d[i] for i in [list(map(int,input().split()))[0] for i in range(int(input()))]]))