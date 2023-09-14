from collections import deque
def solution(priorities, location):
    queue = deque((i,j) for i,j in enumerate(priorities))
    answer = []
    while queue:
        process = queue.popleft()
        if queue and any(process[1] < p[1] for p in queue):
            queue.append(process)
        else:
            answer.append(process)
            
    for i in answer:
        if i[0] == location:
            return answer.index(i) + 1
    