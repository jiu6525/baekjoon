def solution(s):
    match = {')': '('}
    stack = []
    for c in s:
        if c in '(':
            stack.append(c)
        elif c in match:
            if len(stack) == 0:
                return False
            else:
                stack.pop()
    answer = True if not bool(len(stack)) else False
    return answer