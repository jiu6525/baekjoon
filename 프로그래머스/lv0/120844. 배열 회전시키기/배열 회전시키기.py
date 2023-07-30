def solution(numbers, direction):
    answer = []
    if direction == "right":
        for i in range(-1,len(numbers)-1):
            answer.append(numbers[i])
        return answer 
    else:
        for i in range(1,len(numbers)+1):
            if i%len(numbers)==0:
                answer.append(numbers[0])
            else:
                answer.append(numbers[i])
        return answer