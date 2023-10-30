x1, y1 = map(float, input().split())
x2, y2 = map(float, input().split())
x3, y3 = map(float, input().split())

if x1 == x2 or x2 == x3 or x3 == x1:
    if x1 == x2 and x2 == x3:
        print("WHERE IS MY CHICKEN?")
    else:
        print("WINNER WINNER CHICKEN DINNER!")
elif y1 == y2 or y2 == y3 or y3 == y1:
    if y1 == y2 and y2 == y3:
        print("WHERE IS MY CHICKEN?")
    else:
        print("WINNER WINNER CHICKEN DINNER!")
else:
    if (y2 - y1) / (x2 - x1) == (y3 - y1) / (x3 - x1):
        print("WHERE IS MY CHICKEN?")
    else:
        print("WINNER WINNER CHICKEN DINNER!")
