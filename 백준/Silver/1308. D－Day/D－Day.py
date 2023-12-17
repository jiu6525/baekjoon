from datetime import *
today = list(map(int, input().split()))
day = list(map(int, input().split()))
if today[0] + 1000 < day[0]:
    print("gg")
elif today[0] + 1000 == day[0] and (today[1], today[2]) <= (day[1], day[2]):
    print("gg")
else:
    today = date(*today)
    day = date(*day)
    print("D-"+str(day.toordinal() - today.toordinal()))