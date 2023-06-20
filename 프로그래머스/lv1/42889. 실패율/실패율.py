def solution(N, stages):
    ls= len(stages)
    answer = []

    for i in range(1,N+1):
        x = stages.count(i) 
        a = 0 if x==0 else x/ls
        answer.append([a,i])
        ls -= x
    answer = sorted(answer,reverse=True, key= lambda x:x[0])
    answer = [i[1] for i in answer]
    return answer