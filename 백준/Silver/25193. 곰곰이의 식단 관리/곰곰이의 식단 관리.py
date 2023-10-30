k = int(input())
n = input()
cn = n.count("C")
print(len(n)//(len(n)-cn+1))