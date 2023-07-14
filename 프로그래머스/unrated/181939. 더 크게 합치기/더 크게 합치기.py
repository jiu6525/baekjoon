def solution(a, b):
    a,b = str(a),str(b)
    return int(max(a+b,b+a))