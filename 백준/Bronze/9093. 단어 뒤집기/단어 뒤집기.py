n = int(input())
for i in range(n):
    words = input().split()
    for j in range(len(words)):
        words[j] = words[j][::-1]

    print(" ".join(words))