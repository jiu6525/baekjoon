n,m = map(int,input().split())
num = list(map(int,input().split()))

board = []

for i in range(n):
    board.append(list(map(int,input().split())))

ans = 0 
for i in range(m-1):
    ans += board[num[i]-1][num[i+1]-1]

print(ans)