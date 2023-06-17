def solution(s):
    alpa = {"zero":0,"one":1,"two":2,"three":3,"four":4,"five":5,"six":6,"seven":7,"eight":8,"nine":9}

    answer = ""
    index = 0
    for i in range(len(s)):
        if s[index:i+1] in alpa:
            answer += str(alpa[s[index:i+1]])
            index = i+1

        if not s[i].isalpha():
            answer += s[i]
            index = i+1
            
    return int(answer)
