def solution(id_pw, db):
    id,pw = id_pw
    answer = ""
    for i,j in db:
        if id == i and pw == j:
            return "login"
        elif id == i:
            return "wrong pw"
    return "fail"