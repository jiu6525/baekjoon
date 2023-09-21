while 1:
    d = {"(":")","[":"]"}
    a = input()
    if a == ".":
        break
    stack = []
    for i in a:
        if i in ("(",")","[","]"):
            if not stack:
                if i == ")" or i=="]":
                    stack.append(i)
                    break
            if i in d:
                stack.append(i)
            else:
                s = stack.pop()
                if d[s] == i:
                    continue
                stack.append(i)
                break
                
    if stack:
        print("no")
    else:
        print("yes")