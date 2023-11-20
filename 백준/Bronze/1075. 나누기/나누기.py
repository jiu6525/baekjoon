n,f=input(),input()
nn=int(n[:-2]+'00')

while True:
    if nn%int(f)==0:
        break
    nn+=1
nn=str(nn)
print(nn[-2:])