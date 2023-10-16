people = []
for i in range(int(input())):
    people.append(input())
ack = sorted(people)
dck = sorted(people,reverse=True)
if people == ack:
    print("INCREASING")
elif people == dck:
    print("DECREASING")
else:
    print("NEITHER")