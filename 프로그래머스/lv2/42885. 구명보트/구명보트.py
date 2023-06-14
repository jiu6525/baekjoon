def solution(people, limit):
    answer = 0
    people.sort()
    s,e = 0,len(people)-1

    while s<=e:
        a = people[s] + people[e]
        if a <= limit:
            answer += 1
            s += 1
            e -= 1
        else:
            answer += 1
            e -=1

    return answer