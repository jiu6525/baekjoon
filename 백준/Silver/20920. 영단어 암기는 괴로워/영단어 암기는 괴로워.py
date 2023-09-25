n,m = map(int,input().split())
arr = []
for i in range(n):
    word = input()
    if len(word) >= m:
        arr.append(word)

words = {}
for i in arr:
    if i not in words:
        words[i] = 1
    else:
        words[i] += 1


arr = sorted(words.items(), key=lambda x:(-x[1],-len(x[0]),x[0]))

for i in arr:
    print(i[0])
