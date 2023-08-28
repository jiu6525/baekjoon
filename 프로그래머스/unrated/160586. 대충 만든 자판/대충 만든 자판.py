def solution(keymap, targets):
    answer = [0 for i in range(len(targets))]
    for i in range(len(targets)):
        for j in targets[i]:
            count = 101
            for z in keymap:
                idx = z.find(j)
                if idx != -1:
                    count = min(count,idx)
            if count == 101:
                answer[i] = -1
                break
            else:
                answer[i] += count + 1

    return answer