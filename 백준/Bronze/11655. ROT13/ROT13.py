upalpa = [chr(i) for i in range(65,91)]
lowalpa = [chr(i) for i in range(97,123)]
s = list(input())
for i in range(len(s)):
    if s[i].isalpha():
        if s[i].isupper():
            s[i] = upalpa[(upalpa.index(s[i])+13)%len(upalpa)]
        else:
            s[i] = lowalpa[(lowalpa.index(s[i])+13)%len(lowalpa)]

print("".join(s))
