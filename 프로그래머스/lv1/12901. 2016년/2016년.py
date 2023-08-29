from datetime import datetime
def solution(a, b):
    return datetime(2016, a, b).strftime("%A")[:3].upper()