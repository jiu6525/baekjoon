def solution(wallpaper):
    idx,jdx = [],[]
    for i in range(len(wallpaper)):
        if "#" in wallpaper[i]:
            for j in range(len(wallpaper[i])):
                if wallpaper[i][j] == "#":
                    idx.append(i)
                    jdx.append(j)
    return [min(idx),min(jdx),max(idx)+1,max(jdx)+1]