n = int(input())
answer = []
for i0 in range(n):
    word = input()
    if word[0] == "0":
        word = word[1:]
    w = ""
    for i in word:
        if i.isdigit():
            w += i
        else:
            if w:
                answer.append(int(w))
                w = ""
    if w:
        answer.append(int(w))

for i in sorted(answer):
    print(i)