def solution(myString, pat):
    myString = myString.replace('A','b')
    myString = myString.replace('B','a')
    myString = myString.replace('b','B')
    myString = myString.replace('a','A')
    return 1 if pat in myString else 0
