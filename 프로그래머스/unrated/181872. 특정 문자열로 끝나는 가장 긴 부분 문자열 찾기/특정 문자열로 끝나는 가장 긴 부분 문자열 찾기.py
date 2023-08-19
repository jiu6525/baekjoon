def solution(myString, pat):
    myString, pat = myString[::-1], pat[::-1]
    idx = myString.index(pat)
    return myString[::-1][:len(myString)-idx]
