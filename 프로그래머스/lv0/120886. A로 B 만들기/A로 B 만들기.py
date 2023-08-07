def solution(before, after):
    before,after = sorted(list(before)),sorted(list(after))
    return int(before==after)