def solution(s, n):
    uword = [chr(i) for i in range(65,91)]
    lword = [chr(i) for i in range(97,123)]

    answer = ""
    for i in s:
        if i == " ":
            answer += i
        else:
            if i.islower():
                index = (lword.index(i) + n)%26
                answer += lword[index]
            else:
                index = (uword.index(i) + n)%26
                answer += uword[index]
    return answer