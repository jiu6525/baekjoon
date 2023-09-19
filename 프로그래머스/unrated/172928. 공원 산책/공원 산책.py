def solution(park, routes):
    route = {"N":(-1,0),"S":(1,0),"W":(0,-1),"E":(0,1)}
    si,sj = 0,0
    for i in range(len(park)):
        for j in range(len(park[0])):
            if park[i][j] == "S":
                si,sj = i,j
                break

    ni,nj = si,sj
    for zi in routes:
        a,b = zi.split()
        dx,dy = route[a]
        for zj in range(int(b)):
            if ni+dx >=len(park) or ni+dx<0 or nj+dy>= len(park[0]) or nj+dy<0:
                ni,nj = si,sj
                break
            if park[ni+dx][nj+dy] == "X":
                ni,nj = si,sj
                break
            ni,nj = ni+dx,nj+dy
        si,sj = ni,nj
            # print(ni,nj)

    return [ni,nj]
# print(ni,nj)