import re

def solution(my_string):
    return sum([int(i) for i in re.findall(r'[0-9]+', my_string)])
