def solution(numbers):
    num = {"zero" : "0", "one" : "1", "two" : "2",
           "three" : "3", "four" : "4", "five" : "5",
            "six" : "6", "seven" : "7", "eight" : "8", "nine" : "9"}
    word,answer = "",""
    for i in numbers:
        word += i
        if word in num: 
            answer += num[word]
            word = ""
    return int(answer)