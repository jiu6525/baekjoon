
def solution(cards1, cards2, goal):
    for i in goal:
        if i in cards1:
            if cards1[0] == i:
                cards1.pop(0)
            else:
                return "No"
        elif i in cards2:
            if cards2[0] == i:
                cards2.pop(0)
            else:
                return "No"
    return "Yes"


