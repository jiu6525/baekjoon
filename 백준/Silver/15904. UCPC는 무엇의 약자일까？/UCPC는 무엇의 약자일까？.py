s = input()
word = 'UCPC' 
idx = 0
for i in s:
    if i == word[idx]:
        idx += 1
    if idx == 4:
        print("I love UCPC")
        break
else:
    print("I hate UCPC")