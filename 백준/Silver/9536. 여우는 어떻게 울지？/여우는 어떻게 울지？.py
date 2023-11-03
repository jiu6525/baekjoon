for i in range(int(input())):
    lst = list(input().split())
    words,ans = [],[]
    while 1:
        word = list(input().split())
        if " ".join(word) == "what does the fox say?":
            break
        words += [word[i] for i in range(len(word)) if i%2==0]
    for j in lst:
        if j not in words:
            ans.append(j)
    print(" ".join(ans))    