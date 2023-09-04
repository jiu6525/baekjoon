def solution(ineq, eq, n, m):
    n,m = str(n),str(m)
    return int(eval(n+ineq+eq+m)) if eq == "=" else int(eval(n+ineq+m))