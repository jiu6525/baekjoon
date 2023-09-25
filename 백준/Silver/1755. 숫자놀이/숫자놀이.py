en = {"0":"zero","1":"one","2":"two","3":"three","4":"four","5":"five","6":"six","7":"seven","8":"eight","9":"nine"}
enr = {v:k for k,v in en.items()}
n,m = map(int,input().split())
l = [i for i in range(n,m+1)]
words = []
for i in l:
    word = ""
    for j in list(str(i)):
        word += en[j] + " "
    words.append(word)

answer = []
for i in sorted(words):
    x = i.split()
    word = ""
    for j in x:
        word += enr[j]
    answer.append(int(word))

for i in range(0,len(answer),10):
    print(" ".join(map(str,answer[i:i+10])))