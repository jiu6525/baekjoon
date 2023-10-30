word = input()
l = list(input().split())
ans = ""
for i in range(len(word)):
    if word[i] in l:
        ans += word[i].lower()
        continue
    ans += word[i]

print(ans)