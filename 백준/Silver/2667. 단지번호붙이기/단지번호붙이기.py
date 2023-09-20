n = int(input())
arr = []
for i in range(n):
    arr.append(list(map(int,input())))

def dfs(x,y):
    global count
    if x<0 or y<0 or x>=n or y>=n:
        return False
    if arr[x][y] == 1:
        arr[x][y] = 0 
        count += 1
        
        dfs(x-1,y)
        dfs(x+1,y)
        dfs(x,y-1)
        dfs(x,y+1)

        return True
    return False,count

count = 0 
result = 0
answer = []
for i in range(n):
    for j in range(n):
        if dfs(i,j) == True:
            result += 1
        if count:
            answer.append(count)
            count = 0

print(result)
answer.sort()
for i in answer:
    print(i)