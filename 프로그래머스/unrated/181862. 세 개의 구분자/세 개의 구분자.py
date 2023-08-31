def solution(myStr):
    answer = [i for i in myStr.replace("a"," ").replace("b"," ").replace("c"," ").split()]
    return  answer if answer else ["EMPTY"] 