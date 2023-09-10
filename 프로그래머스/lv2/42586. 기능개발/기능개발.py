def solution(progresses, speeds):
    days = []
    for i in range(len(progresses)):
        day = ((100-progresses[i])//speeds[i])
        if (100-progresses[i])%speeds[i]>0:
            days.append(day+1)
        else:
            days.append(day)

    # days += [0]
    # [5, 10, 1, 1, 20, 1]
    answer = []
    count = 1
    mday = days[0]
    for i in range(1,len(days)):
        if days[i] <= mday:
            count += 1
        else:
            answer.append(count)
            mday = days[i]
            count = 1

    if count:
        answer.append(count)         
    return answer