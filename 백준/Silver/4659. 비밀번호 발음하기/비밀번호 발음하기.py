while 1:
    word = input()
    m = ["a","e","i","o","u"]
    ans = f'<{word}> is acceptable.'
    if word == "end":
        break
    if any (i in m for i in word):
        if len(word)<=1:
            pass
        else:
            mc = 1 if word[0] in m else 0
            jc = 1 if word[0] not in m else 0
            for i in range(1,len(word)):
                if word[i] in m:
                    mc += 1
                    jc = 0
                else:
                    jc += 1
                    mc = 0
                if mc == 3 or jc == 3:
                    ans = f'<{word}> is not acceptable.'
                    break
                if word[i] == word[i-1]:
                    if word[i] not in ("e","o"):
                        ans = f'<{word}> is not acceptable.'
                        break
    else:
        ans = f'<{word}> is not acceptable.'

    print(ans)