def solution(arr):
    stack = []
    for i in arr:
        if not stack:
            stack.append(i)
        else:
            n = stack.pop(-1)
            if n == i:
                stack.append(i)
            else:
                stack.append(n)
                stack.append(i)
    return stack