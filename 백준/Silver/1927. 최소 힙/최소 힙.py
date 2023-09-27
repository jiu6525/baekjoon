import heapq
heap = []
answer = []
for i in range(int(input())):
    num = int(input())
    if not num:
        if not heap:
            answer.append(0)
        else:
            answer.append(heapq.heappop(heap))
    else:
        heapq.heappush(heap,num)

for i in answer:
    print(i)