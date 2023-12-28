n,m=map(int,input().split())
graph=[]
for i in range(n):
    temp=list(input())
    for j in range(m//2):
        if temp[j]!='.':
            temp[m-j-1]=temp[j]
        elif temp[m-j-1]!='.':
            temp[j]=temp[m-j-1]
    graph.append(temp)
    
for i in range(len(graph)):
    for j in range(len(graph[i])):
        print(graph[i][j],end="")
    print()
