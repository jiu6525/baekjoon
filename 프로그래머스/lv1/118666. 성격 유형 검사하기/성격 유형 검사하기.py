def solution(survey, choices):
    scores = {"A":0, "N":0, "C":0, "F":0, "M":0, "J":0, "R":0, "T":0}
    for idx, choice in enumerate(choices):
        if choice - 4 > 0:
            scores[survey[idx][1]] += choice - 4
        elif choice - 4 < 0:
            scores[survey[idx][0]] += 4 - choice

    answer = ""
    if scores["R"] >= scores["T"]:
        answer += "R"
    else:
        answer += "T"

    if scores["C"] >= scores["F"]:
        answer += "C"
    else:
        answer += "F"

    if scores["J"] >= scores["M"]:
        answer += "J"
    else:
        answer += "M"

    if scores["A"] >= scores["N"]:
        answer += "A"
    else:
        answer += "N"

    return answer