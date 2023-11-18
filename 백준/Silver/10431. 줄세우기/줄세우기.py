from collections import deque

for i0 in range(int(input())):
    c = list(map(int,input().split()))
    n = c[0]
    student = c[1:]
    result = deque()
    ans = 0
    for i in range(len(student)):
        if any(result[j]>student[i] for j in range(len(result))):
            for z in range(len(result)):
                if result[z] > student[i]:
                    ans += len(result) - z
                    result.insert(z,student[i])
                    break
        else:
            result.append(student[i])

    print(f'{n} {ans}')