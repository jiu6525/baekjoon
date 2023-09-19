def solution(keyinput, board):
    route = {"left":(-1,0),"right":(1,0),"down":(0,-1),"up":(0,1)}
    si,sj = 0,0
    li,lj = -(board[0]//2),board[0]//2
    ri,rj = -(board[1]//2),board[1]//2


    for i in keyinput:
        dx,dy = route[i]
        ni,nj = si+dx,sj+dy
        if li<=ni<=lj and ri<=nj<=rj:
            si,sj = ni,nj
    return [si,sj]